const { Kafka } = require('kafkajs');

const kafka = new Kafka({
  clientId: 'my-consumer',
  brokers: ['localhost:9092']
});
 
const consumer = kafka.consumer({groupId: 'consumer-group'});
 
//const run = async () => {
  // Consuming
  /* await consumer.connect()
  await consumer.subscribe({ topic: 'ordenes', fromBeginning: true }) */
  /* await consumer.run({
    eachMessage: async ({ topic, partition, message }) => {
      orden = JSON.parse(message.value.toString());
      articulos = [...orden.articulos];
      articulos.map((articulo) => {
        connection.query(`SELECT * FROM articulos WHERE idArticulos = ${articulo.idArticulo}`, function (error, results, fields) {
            if (error) throw error;
            if (articulo.cantidad > results[0].cantidad) {
                objetoError = articulo;
                noStock = true;
            }
        });
      });
      if (noStock) {
          export var errorNoStock = "Error, stock insuficiente";
      } else {
          export var msg = orden;
      }
    },
  }) */
//}

//connection.end();

//run().catch(console.error)

module.exports = consumer;