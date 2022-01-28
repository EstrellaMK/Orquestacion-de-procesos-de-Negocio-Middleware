package com.mycompany.cuentascobrar;

public class Factura {
    private int idCliente;
    private int idFactura;
    private String estado;
    private String fecha;
    private double totalIGV;
    private double totalCobrar;

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the idFactura
     */
    public int getIdFactura() {
        return idFactura;
    }

    /**
     * @param idFactura the idFactura to set
     */
    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the totalIGV
     */
    public double getTotalIGV() {
        return totalIGV;
    }

    /**
     * @param totalIGV the totalIGV to set
     */
    public void setTotalIGV(double totalIGV) {
        this.totalIGV = totalIGV;
    }

    /**
     * @return the totalCobrar
     */
    public double getTotalCobrar() {
        return totalCobrar;
    }

    /**
     * @param totalCobrar the totalCobrar to set
     */
    public void setTotalCobrar(double totalCobrar) {
        this.totalCobrar = totalCobrar;
    }
    
    
    
}
