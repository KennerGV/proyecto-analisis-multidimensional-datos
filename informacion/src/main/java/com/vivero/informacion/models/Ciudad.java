package com.vivero.informacion.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Ciudad
 */
@Entity
@Table(name="CIUDAD")
public class Ciudad {

    @Id
    private int ciudadId;

    private String ciudadNombre;
    
    @OneToOne
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;

    public int getCiudadId() {
        return this.ciudadId;
    }

    public void setCiudadId(int ciudadId) {
        this.ciudadId = ciudadId;
    }

    public String getCiudadNombre() {
        return this.ciudadNombre;
    }

    public void setCiudadNombre(String ciudadNombre) {
        this.ciudadNombre = ciudadNombre;
    }

    public Provincia getProvinciaId() {
        return this.provincia;
    }

    public void setProvinciaId(Provincia provincia) {
        this.provincia = provincia;
    }

    
}