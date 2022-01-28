/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reservaM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ActualizandoBD {
    
    //Conectamos la Base de Datos
    Conexion con = new Conexion();
    Connection cn = con.conexion();
    int monto;
    
    public void Actualiza(ArrayList<Articulo> articulos){
        int tamanio = articulos.size();
        for(int i=0;i<tamanio;i++){
            String sql_cantidad = "";
            int cantidadSQL = 0;
            System.out.println(articulos.get(i).nombreArticulo);
            sql_cantidad = String.valueOf("SELECT cantidad FROM articulos WHERE idArticulos ="+ articulos.get(i).getIdArticulo());
            System.out.println(sql_cantidad);
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql_cantidad);
                while (rs.next()){
                    cantidadSQL =  rs.getInt (1);
                }
                monto = cantidadSQL -articulos.get(i).cantidad;
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            Tabla_Actualizada(monto,articulos.get(i).getIdArticulo()); 
        }
    }

    public void Tabla_Actualizada(int cantidad, int idArticulo){
        String sql_actualiza="";
        sql_actualiza = "UPDATE articulos SET cantidad = "+cantidad+" WHERE idArticulos ="+idArticulo;
        try {
                PreparedStatement st = cn.prepareStatement(sql_actualiza);
                st.executeUpdate();
                //ResultSet rs = st.executeUpdate(sql_actualiza);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
    }   
}