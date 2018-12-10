package com.vivero.datawarehouse.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Venta
 */
@Entity
@Table(name="H_VENTA")
public class Venta {

    @Id
    private int idVenta;

    @OneToOne
    @JoinColumn(name="id_producto")
    private Producto producto;

    @OneToOne
    @JoinColumn(name="id_sucursal")
    private Sucursal sucursal;

    @OneToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name="id_vendedor")
    private Vendedor vendedor;

    @OneToOne
    @JoinColumn(name="id_tiempo")
    private Tiempo tiempo;    

    private int cantidadVenta;
    
    private int montoVenta;

    
    public int getCantidadVenta() {
        return this.cantidadVenta;
    }

    public void setCantidadVenta(int cantidadVenta) {
        this.cantidadVenta = cantidadVenta;
    }

    public int getMontoVenta() {
        return this.montoVenta;
    }

    public void setMontoVenta(int montoVenta) {
        this.montoVenta = montoVenta;
    }
    public int getIdVenta() {
        return this.idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Sucursal getSucursal() {
        return this.sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return this.vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Tiempo getTiempo() {
        return this.tiempo;
    }

    public void setTiempo(Tiempo tiempo) {
        this.tiempo = tiempo;
    }

    
}