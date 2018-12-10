package com.vivero.datawarehouse.models.crud;

import com.vivero.datawarehouse.models.Vendedor;

import org.springframework.data.repository.CrudRepository;

/**
 * Vendedor
 */
public interface VendedorCrud extends CrudRepository<Vendedor, Integer>{

    
}