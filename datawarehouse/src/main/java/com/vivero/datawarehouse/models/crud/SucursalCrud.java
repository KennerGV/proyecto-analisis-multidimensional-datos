package com.vivero.datawarehouse.models.crud;

import com.vivero.datawarehouse.models.Sucursal;

import org.springframework.data.repository.CrudRepository;

/**
 * SucursalCrud
 */
public interface SucursalCrud extends CrudRepository<Sucursal, Integer>{

    
}