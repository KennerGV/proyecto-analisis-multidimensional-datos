package com.vivero.datawarehouse.models.crud;

import com.vivero.datawarehouse.models.Tiempo;

import org.springframework.data.repository.CrudRepository;

/**
 * TiempoCrud
 */
public interface TiempoCrud extends CrudRepository<Tiempo, Integer>{

    
}