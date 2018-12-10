package com.vivero.informacion.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Provincia
 */
@Entity
@Table(name="PROVINCIA")
public class Provincia {

    @Id
    private int provinciaId;
    
    private String provinciaNombre;

    @OneToOne
    @JoinColumn(name="region_id")
    private Region region;

    public int getProvinciaId() {
        return this.provinciaId;
    }

    public void setProvinciaId(int provinciaId) {
        this.provinciaId = provinciaId;
    }

    public String getProvinciaNombre() {
        return this.provinciaNombre;
    }

    public void setProvinciaNombre(String provinciaNombre) {
        this.provinciaNombre = provinciaNombre;
    }

    public Region getRegion() {
        return this.region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    
}