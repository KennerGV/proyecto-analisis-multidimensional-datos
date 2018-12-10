package com.vivero.informacion.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Venta
 */
@Entity
@Table(name="VENTAS")
public class Venta implements Serializable{

    private static final long serialVersionUID = 1L;
   
    @Id
    private int id;
    
    @OneToOne
    @JoinColumn(name="documento")
    private DetalleVenta detalleVenta;

    private Timestamp fecha;

    @Column(name="id_cliente")
    private String cliente;
   /*  @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente; */

    private String tipoDocumento;
    
    @Column(name = "id_vendedor")
    private String vendedor;
    
    /* @OneToOne
    @JoinColumn(name = "id_vendedor")
    private Vendedor vendedor; */

    private int totalNeto;

    private int impuesto;

    private int totalDocumento;

    @Column(name = "sucursal_id")
    private int sucursal;

    /* @OneToOne
    @JoinColumn(name="sucursal_id")
    private Sucursal sucursal; */

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DetalleVenta getDocumento() {
        return this.detalleVenta;
    }

    public void setDocumento(DetalleVenta documento) {
        this.detalleVenta = documento;
    }

    public Timestamp getFecha() {
        return this.fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getIdCliente() {
        return this.cliente;
    }

    public void setIdCliente(String idCliente) {
        this.cliente = idCliente;
    }

    public String getTipoDocumento() {
        return this.tipoDocumento;
    }

     public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getIdVendedor() {
        return this.vendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.vendedor = idVendedor;
    }

    public int getTotalNeto() {
        return this.totalNeto;
    }

    public void setTotalNeto(int totalNeto) {
        this.totalNeto = totalNeto;
    }

    public int getImpuesto() {
        return this.impuesto;
    }

    public void setImpuesto(int impuesto) {
        this.impuesto = impuesto;
    }

    public int getTotalDocumento() {
        return this.totalDocumento;
    }

    public void setTotalDocumento(int totalDocumento) {
        this.totalDocumento = totalDocumento;
    }

    public int getSucursalId() {
        return this.sucursal;
    }

    public void setSucursalId(int sucursalId) {
        this.sucursal = sucursalId;
    }
   
    
}