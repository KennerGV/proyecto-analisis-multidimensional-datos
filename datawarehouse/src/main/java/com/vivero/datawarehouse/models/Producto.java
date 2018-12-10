package com.vivero.datawarehouse.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Producto
 */
@Entity
@Table(name="D_PRODUCTO")
public class Producto {

    @Id
    private String idProducto;
    private String nombreProducto;
    private String familiaProducto;

    public String getIdProducto() {
        return this.idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getFamiliaProducto() {
        return this.familiaProducto;
    }

    public void setFamiliaProducto(String familiaProducto) {
        this.familiaProducto = familiaProducto;
    }

}