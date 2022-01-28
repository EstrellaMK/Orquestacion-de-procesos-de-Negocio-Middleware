/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.procesamientoordenes;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import javax.swing.JOptionPane;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 *
 * @author PC
 */
public class ConsumidorStock {
     public static void main( String[] args ){
      
        Properties props = new Properties();
      

        //PROCESAMIENTO DE LLEGADA DE DATOS
        //Identificación del cluster
        props.put( "bootstrap.servers", "localhost:9092" );
        //Deserializamos 
        props.put( "key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer" );
        props.put( "value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer" );
        //Grupo de consumidores del cliente
        props.put( "group.id", "test-consumer-group" );
        
        try( KafkaConsumer<String, String> consumer = new KafkaConsumer<>( props ) ){
            consumer.subscribe( Collections.singletonList( "no-stock" )); //Suscribo a mi consumidor
            while( true ){
           
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("Mensaje recibido"+record.value());
                
                   
                    JOptionPane.showMessageDialog(null,record.value() );
                    
                    
                   
                }
            }
        }
        
        
     }
}
