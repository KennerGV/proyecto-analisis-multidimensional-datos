package com.vivero.datawarehouse.models.crud;

import com.vivero.datawarehouse.models.Venta;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * VentaCrud
 */
public interface VentaCrud extends CrudRepository<Venta, Integer>{

    public Iterable<Venta> findAll(Pageable page);
    
}