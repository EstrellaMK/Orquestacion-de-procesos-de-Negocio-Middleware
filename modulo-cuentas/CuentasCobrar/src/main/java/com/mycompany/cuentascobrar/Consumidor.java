/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cuentascobrar;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 *
 * @author PC
 */
public class Consumidor {
     public static void main( String[] args ){
      
        Properties props = new Properties();
        Mensaje mensajeRecibido = new Mensaje();
        int size = 0;
        boolean nuevo = false;
        
        

        // Creamos ArrayList para almacenar los articulos
        ArrayList<Articulo> listaArticulos = new ArrayList<>();
        
        // Creamos un objeto de clse ActualizandoBD para actualizar la BD articulos
        ActualizandoBD reduce = new ActualizandoBD();
        
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
            consumer.subscribe( Collections.singletonList( "cuentas" )); //Suscribo a mi consumidor
            while( true ){
                // Cuantos mensajes deseo traer
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("Mensaje recibido"+record.value());
                    //Transformamos el Json a objetos a través de Gson
                    // Creamos la clase Mensaje
                    mensajeRecibido = new Gson().fromJson(record.value(),Mensaje.class);
                    System.out.println(mensajeRecibido);
                    String mensajito = String.valueOf(mensajeRecibido.getArticulos().size());
                    size = Integer.parseInt(mensajito);
                   
                    for(int i =0;i<size;i++){
                        arti = new Articulo(mensajeRecibido.getArticulos().get(i).idArticulo, mensajeRecibido.getArticulos().get(i).getNombreArticulo(),mensajeRecibido.getArticulos().get(i).precioArticulo,mensajeRecibido.getArticulos().get(i).cantidad);
                        listaArticulos.add(arti);
                        
                    }
                    Mensaje msg = new Mensaje(mensajeRecibido.getIdCliente(),listaArticulos,mensajeRecibido.getTotal(),mensajeRecibido.getIdFactura());
                    reduce.InsertarCC(msg);

                    //Enviando mensaje a Facturación, convertimos el objeto en JSON.
                    Gson convertidor = new Gson();
                    
                    productor.enviar(mensajeRecibido.getIdCliente());
                    System.out.println("El mensaje fue enviado a Ordenes: "+mensajeRecibido.getIdCliente());
                }
            }//
        }
        
        
     }
}
