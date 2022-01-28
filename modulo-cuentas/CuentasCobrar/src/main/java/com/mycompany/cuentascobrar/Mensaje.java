/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuentascobrar;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Mensaje{
    public String idCliente;
    public ArrayList<Articulo> articulos;
    public double total;
    public int idFactura;
    
    public Mensaje(String idCliente, ArrayList<Articulo> articulos, double total, int idFactura) {
        this.idCliente = idCliente;
        this.articulos = articulos;
        this.total = total;
        this.idFactura = idFactura;
    }

    public Mensaje() {
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList<Articulo> getArticulos(){
        return articulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }

    public double getTotal() {
        Double resultado = 0.0;
        for (int counter = 0; counter < this.articulos.size(); counter++) { 		      
            resultado += this.articulos.get(counter).getPrecioArticulo();
        }
        return resultado;
    }

    public void setTotal(double total) {
        this.total = total;
    }    

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
    
    
}
