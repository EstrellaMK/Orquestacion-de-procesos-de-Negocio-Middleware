/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reservaM;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class Productor {
        // Properties prop = new LectorPropiedades().getProperties();
    Properties prop = new Properties();

    public void enviar(String mensaje) {
        
        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(prop);
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("facturacion", mensaje);
        producer.send(record);
       /* KafkaProducer<String, byte[]> producer = new KafkaProducer<>(this.prop, new StringSerializer(), new ByteArraySerializer());
        byte[] flujo = mensaje.getBytes();
        ProducerRecord<String, byte[]> record = new ProducerRecord<>(prop.getProperty("kafka.topic.ordenes"), flujo);
        producer.send(record);
        producer.close();*/
    }  
}
