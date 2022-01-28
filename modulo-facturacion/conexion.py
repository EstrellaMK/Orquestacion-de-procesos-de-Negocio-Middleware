import mysql.connector

cn = mysql.connector.connect(user='root', password='Admin123',
                              host='127.0.0.1',
                              database='fisiutiles')


print("Conexion establecida correctamente")
