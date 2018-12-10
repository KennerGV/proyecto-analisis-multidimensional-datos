package com.vivero.informacion.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * DetalleVenta
 */
@Entity
@Table(name="DETALLE_VENTA")
public class DetalleVenta implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    private String documento;

    @OneToOne
    @JoinColumn(name="codigo_producto")
    private Articulo codigoProducto;

    private int precioUnitario;

    private int cantidad;

    private int total;

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Articulo getCodigoProducto() {
        return this.codigoProducto;
    }

    public void setCodigoProducto(Articulo codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getPrecioUnitario() {
        return this.precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    
}