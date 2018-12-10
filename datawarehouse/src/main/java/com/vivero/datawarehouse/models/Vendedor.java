package com.vivero.datawarehouse.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Vendedor
 */
@Entity
@Table(name="D_VENDEDOR")
public class Vendedor {

    @Id
    private int idVendedor;
    private String nombreVendedor;
    private String tipoCapacitacion;
    private int horaCapacitacion;

    public int getIdVendedor() {
        return this.idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNombreVendedor() {
        return this.nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getTipoCapacitacion() {
        return this.tipoCapacitacion;
    }

    public void setTipoCapacitacion(String tipoCapacitacion) {
        this.tipoCapacitacion = tipoCapacitacion;
    }

    public int getHoraCapacitacion() {
        return this.horaCapacitacion;
    }

    public void setHoraCapacitacion(int horaCapacitacion) {
        this.horaCapacitacion = horaCapacitacion;
    }
}