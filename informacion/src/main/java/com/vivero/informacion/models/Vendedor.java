package com.vivero.informacion.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Vendedores
 */
@Entity
@Table(name="VENDEDORES")
public class Vendedor {
    
    @Id
    private int idVendedor;

    private String nombre;

    private String apellido;
    
    private String tipoCapacitacion;

    private int horasCapacitacion;

    public int getIdVendedor() {
        return this.idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
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

    public String getTipoCapacitacion() {
        return this.tipoCapacitacion;
    }

    public void setTipoCapacitacion(String tipoCapacitacion) {
        this.tipoCapacitacion = tipoCapacitacion;
    }

    public int getHorasCapacitacion() {
        return this.horasCapacitacion;
    }

    public void setHorasCapacitacion(int horasCapacitacion) {
        this.horasCapacitacion = horasCapacitacion;
    }


    
}