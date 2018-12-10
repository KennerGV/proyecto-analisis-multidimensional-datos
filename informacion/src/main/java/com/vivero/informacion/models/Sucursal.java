package com.vivero.informacion.models;

import java.util.concurrent.PriorityBlockingQueue;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Sucursal
 */
@Entity
@Table(name="SUCURSAL")
public class Sucursal {

    @Id
    private int sucursalId;

    private String nombreSucursal;
    
    @OneToOne
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;

    public int getSucursalId() {
        return this.sucursalId;
    }

    public void setSucursalId(int sucursalId) {
        this.sucursalId = sucursalId;
    }

    public String getNombreSucursal() {
        return this.nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public Ciudad getCiudadId() {
        return this.ciudad;
    }

    public void setCiudadId(Ciudad ciudad) {
        this.ciudad = ciudad;
    }


    
}