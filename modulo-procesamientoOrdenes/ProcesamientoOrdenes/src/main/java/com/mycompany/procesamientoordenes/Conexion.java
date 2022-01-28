/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.procesamientoordenes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class Conexion {
    
    //Atributos

    Connection cn;
    static String bd="fisiutiles";
    static String usuario="root";
    static String contrasenia="Admin123";

    //Métodos

    public Connection conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn= DriverManager.getConnection("jdbc:mysql://localhost/"+bd,usuario,contrasenia);
            System.out.println("Se hizo la conexión con la Base de Datos exitosamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());System.out.println("Eror al conectar");
        }
        return cn;
    }

    Statement creStatement(){
        throw new UnsupportedOperationException("No se pudo conectar con la Base de Datos");
    }

    public static void main(String[] args) {
        Conexion cn = new Conexion();
        cn.conexion();
    }
}

