package com.vivero.datawarehouse.models.crud;

import com.vivero.datawarehouse.models.Producto;

import org.springframework.data.repository.CrudRepository;

/**
 * ProductoCrud
 */
public interface ProductoCrud extends CrudRepository<Producto, String>{

    
}