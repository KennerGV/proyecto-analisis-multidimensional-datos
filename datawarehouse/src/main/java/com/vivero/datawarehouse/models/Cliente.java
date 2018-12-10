package com.vivero.datawarehouse.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Cliente
 */
@Entity
@Table(name="D_Cliente")
public class Cliente {

    @Id
    private String idCliente;
    private String nombreCliente;
    private int edadCliente;
    private String estadoCivil; 

    public String getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return this.nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getEdadCLiente() {
        return this.edadCliente;
    }

    public void setEdadCliente(int edad) {
        this.edadCliente = edad;
    }

    public String getEstadoCivil() {
        return this.estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}