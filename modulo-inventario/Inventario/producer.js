const { Kafka } = require('kafkajs');
 
const kafka = new Kafka({
  clientId: 'my-producer',
  brokers: ['localhost:9092']
});
 
const producer = kafka.producer();
 
//const run = async () => {
  // Producing
  /* await producer.connect()
  if (errorNoStock !== undefined || errorNoStock !== null || orden !== undefined || orden !== null) {
    if (errorNoStock !== null || errorNoStock !== undefined) {
        await producer.send({
          topic: 'test-topic',
          messages: [
            { value: errorNoStock },
          ],
        })
      } else {
        await producer.send({
            topic: 'test-topic',
            messages: [
              { value: orden },
            ],
        })
      }
  } */
//}
 
//run().catch(console.error)

module.exports = producer;