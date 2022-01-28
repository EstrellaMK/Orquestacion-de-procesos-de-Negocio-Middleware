/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.procesamientoordenes;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Orden {
    
    private String idCliente;
    
    private ArrayList<Articulo> articulos;
    
    private double total;

    public Orden(String idCliente, ArrayList<Articulo> articulos, double total) {
        this.idCliente = idCliente;
        this.articulos = articulos;
        this.total = total;
    }

    public Orden() {
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList<Articulo> getArticulos() {
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
    
    
    
}
