/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuentascobrar;

/**
 *
 * @author Usuario
 */
public class Articulo {
    
    int idArticulo;
    String nombreArticulo;
    double precioArticulo;
    int cantidad;
    
    
    public Articulo(int idArticulo, String nombreArticulo, double precioArticulo) {
        this.idArticulo = idArticulo;
        this.nombreArticulo = nombreArticulo;
        this.precioArticulo = precioArticulo;
    }

    public Articulo(int idArticulo, String nombreArticulo, double precioArticulo, int cantidad) {
        this.idArticulo = idArticulo;
        this.nombreArticulo = nombreArticulo;
        this.precioArticulo = precioArticulo;
        this.cantidad = cantidad;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public double getPrecioArticulo() {
        return precioArticulo;
    }

    public void setPrecioArticulo(double precioArticulo) {
        this.precioArticulo = precioArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public String[] convertirString() {
        return new String[]{Integer.toString(idArticulo), nombreArticulo,Double.toString(precioArticulo), Integer.toString(cantidad)};
    }

}

