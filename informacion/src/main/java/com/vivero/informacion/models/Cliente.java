package com.vivero.informacion.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Cliente
 */
@Entity
@Table(name="CLIENTES")
public class Cliente {

    private int nro;

    @Id
    private String idCliente;

    private String nombre;

    private String apellido;

    private int edad;

    private String estadoCivil;

    private String residencia;

    private String origen;

    public int getNro() {
        return this.nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public String getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstadoCivil() {
        return this.estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getResidencia() {
        return this.residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public String getOrigen() {
        return this.origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    
}