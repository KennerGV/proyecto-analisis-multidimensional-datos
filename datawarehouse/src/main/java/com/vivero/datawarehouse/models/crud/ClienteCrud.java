package com.vivero.datawarehouse.models.crud;

import com.vivero.datawarehouse.models.Cliente;

import org.springframework.data.repository.CrudRepository;

/**
 * ClienteCrud
 */
public interface ClienteCrud extends CrudRepository<Cliente, String>{

    
}