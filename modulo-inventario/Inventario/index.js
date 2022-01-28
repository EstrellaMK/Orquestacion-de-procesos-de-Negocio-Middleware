const connection = require('./database');
const consumer = require('./consumer');
const producer = require('./producer')

connection.connect((error) => {
    !!error ? console.log(error) : console.log("Connected");
});

let orden = {};
let articulos = [];

const run = async () => {
    await consumer.connect();
    await producer.connect();
    await consumer.subscribe({ topic: 'ordenes', fromBeginning: true });
    await consumer.run({
        eachMessage: async ({ topic, partition, message }) => {
            orden = JSON.parse(message.value.toString());
            articulos = [...orden.articulos];
            let stop = false;
            articulos.map((articulo) => {
                connection.query(`SELECT * FROM articulos WHERE idArticulos = ${articulo.idArticulo}`, function (error, results, fields) {
                    if (error) throw error;
                    if (articulos[articulos.length - 1].idArticulo == articulo.idArticulo) {
                        /* ÚLTIMO */
                        if (articulo.cantidad > results[0].cantidad) {
                            producer.send({
                                topic: 'no-stock',
                                messages: [
                                    { value: `No hay stock suficiente para el artículo: ${articulo.nombreArticulo}` },
                                ],
                            });
                        } else {
                            if (!stop) {
                                console.log(orden);
                                producer.send({
                                    topic: 'reservas',
                                    messages: [
                                        { value: message.value.toString() },
                                    ],
                                });
                            }
                        }
                    } else {
                        /* NO ÚLTIMO */
                        if (articulo.cantidad > results[0].cantidad) {
                            stop = true;
                            producer.send({
                                topic: 'no-stock',
                                messages: [
                                    { value: "No hay stock suficiente para alguno de los productos seleccionados." },
                                ],
                            });
                        }
                    }
                });
            });
          },
    })
}

run().catch(console.error);