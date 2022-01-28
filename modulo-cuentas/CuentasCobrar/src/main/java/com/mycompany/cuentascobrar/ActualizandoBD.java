/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuentascobrar;

/**
 *
 * @author Usuario
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ActualizandoBD {
    
    //Conectamos la Base de Datos
    Conexion con = new Conexion();
    Connection cn = con.conexion();
    int monto;
    
    public String fecha(){
        LocalDate localDate = LocalDate.now();//For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String formattedString = localDate.format(formatter);
        return formattedString;
    }
    
    public int cantidadCC(){
        String sql_cantidad = "SELECT COUNT(*) FROM cuentascobrar";
        int cantidadSQL = 0;
        try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql_cantidad);
                while (rs.next()){
                    cantidadSQL =  rs.getInt (1);
                }
               
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        
    
        return cantidadSQL +1;
    }
    
    public void InsertarCC(Mensaje data){
       
        double igv = 0.18;
        double monto =data.getTotal()+data.getTotal()*igv;
        String estado = "Pendiente";
        String sql= "INSERT INTO cuentascobrar (idcuentasCobrar,idCliente,idFactura,estado,fecha,totalIGV,totalCobrar) VALUES ("+cantidadCC()+","+Integer.parseInt(data.getIdCliente())+","+data.getIdFactura()+","+"'"+estado+"'"+",CURRENT_TIMESTAMP (),"+data.getTotal()+","+monto+")";
        
  
        try {
                System.out.println(sql);
               PreparedStatement ps = cn.prepareStatement(sql);               
            
               ps.executeUpdate();
               
            } catch (SQLException ex) {
                System.out.println(ex);
            }
     }       
}