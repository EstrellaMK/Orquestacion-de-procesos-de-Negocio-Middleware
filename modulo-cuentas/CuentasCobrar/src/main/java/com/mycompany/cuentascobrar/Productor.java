/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cuentascobrar;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 *
 * @author PC
 */
public class Productor {
    // Properties prop = new LectorPropiedades().getProperties();
    Properties prop = new Properties();

    public void enviar(String mensaje) {
        
        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(prop);
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("newordenes", mensaje);
        producer.send(record);
        
       /* KafkaProducer<String, byte[]> producer = new KafkaProducer<>(this.prop, new StringSerializer(), new ByteArraySerializer());
        byte[] flujo = mensaje.getBytes();
        ProducerRecord<String, byte[]> record = new ProducerRecord<>(prop.getProperty("kafka.topic.ordenes"), flujo);
        producer.send(record);
        producer.close();*/
    }
}
