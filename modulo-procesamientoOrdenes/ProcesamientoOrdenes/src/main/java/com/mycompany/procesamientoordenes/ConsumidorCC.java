/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.procesamientoordenes;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import java.util.stream.StreamSupport;
import javax.swing.JFrame;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
/**
 *
 * @author Usuario
 */
public class ConsumidorCC {
     public static void main( String[] args ){
      
        Properties props = new Properties();
        Mensaje mensajeRecibido = new Mensaje();
        
        int size = 0;
        boolean nuevo = false;

        // Creamos ArrayList para almacenar los articulos
        ArrayList<Articulo> listaArticulos = new ArrayList<>();
        
        // Creamos un objeto de clse ActualizandoBD para actualizar la BD articulos
      
        
        Articulo arti;
        
        //CREAMOS PRODUCTOR PARA ENVIAR FACTURACION
        Productor productor = new Productor();

        //PROCESAMIENTO DE LLEGADA DE DATOS
        //Identificación del cluster
        props.put( "bootstrap.servers", "localhost:9092" );
        //Deserializamos 
        props.put( "key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer" );
        props.put( "value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer" );
        //Grupo de consumidores del cliente
        props.put( "group.id", "test-consumer-group" );
        
        try( KafkaConsumer<String, String> consumer = new KafkaConsumer<>( props ) ){
            consumer.subscribe( Collections.singletonList( "newordenes" )); //Suscribo a mi consumidor
            while( true ){
                // Cuantos mensajes deseo traer
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("Mensaje recibido"+record.value());
                    //Transformamos el Json a objetos a través de Gson
                    // Creamos la clase Mensaje
                    
                    
                    
                    cuentasCobrar c = new cuentasCobrar(record.value());
                    c.setVisible(true);
                    

                    //Enviando mensaje a Facturación, convertimos el objeto en JSON.
                   
                }
            }
            
            
        }   
        
 
          
            
        
    }   
}
