
from ast import Return
from sqlite3 import Cursor
from kafka import KafkaConsumer
import kafka
import json
import mysql.connector
import producer

cn = mysql.connector.connect(user='root', password='Admin123',
                              host='127.0.0.1',
                              database='fisiutiles')





def recibir_mensajeReserva():
    print("Esperando ....")
    consumer = KafkaConsumer(bootstrap_servers=['localhost:9092'], value_deserializer=lambda m: json.loads(m.decode('ascii')))
    consumer.subscribe(['facturacion'])


    ##Recibe el mensaje de Reserva
    for msg in consumer:
        print("Recibido del Módulo de Reserva: ")
        msgOfReserva = msg.value
        idFactura = cantidadFactura()
        insertar_factura(msgOfReserva, cantidadFactura())
        insertar_detalleFactura(msgOfReserva, cantidadFactura()-1,cantidadDetalleFactura())
     
        msgOfReserva.update({'idFactura': idFactura})
        print(msgOfReserva)
        producer.produce_message("cuentas",msgOfReserva)
           
        print("Mensaje Enviado a cuentas por cobrar")
        print("Esperando ....")





def cantidadFactura():
    cursor = cn.cursor()
    cursor.execute("select COUNT(*) from facturas")
    
    cF = cursor.fetchone()
    cantidadF = int(cF[0])
    cantidadF+=1
    return  cantidadF

def cantidadDetalleFactura():
    cursor = cn.cursor()
    cursor.execute("select COUNT(*) from detallefactura")
    
    cDF = cursor.fetchone()
    cantidadDF = int(cDF[0])
    cantidadDF +=1
    return cantidadDF
            

def insertar_factura(msgToFacturacion, i):
    print("Entro")
    cursor = cn.cursor()
    sql = "INSERT INTO facturas (idFacturas,totalIGV,totalFactura,idCliente) VALUES(%s, %s,%s, %s)"
    igv = msgToFacturacion['total'] + msgToFacturacion['total']*0.18
    print(igv)
    val = (i,igv,msgToFacturacion['total'],msgToFacturacion['idCliente'])
    cursor.execute(sql,val)
    cn.commit()
    print("Insertado")
    



def insertar_detalleFactura(msgToFacturacion,i,j):
    cursor = cn.cursor()
    contador = len(msgToFacturacion['articulos'] )
    sql = "INSERT INTO detallefactura (idDetalleFactura,idFactura,precio,cantidad,idArticulo) VALUES(%s, %s,%s, %s,%s)"
    x = 0

    while(contador>0):
        val = (j,i,msgToFacturacion['articulos'][x]['precioArticulo'],msgToFacturacion['articulos'][x]['cantidad'],msgToFacturacion['articulos'][x]['idArticulo'])
        contador -=1
        x +=1
        j +=1
        cursor.execute(sql,val)
        cn.commit()

    print("Actualizado")
    




       

    
