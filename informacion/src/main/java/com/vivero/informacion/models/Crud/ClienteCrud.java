package com.vivero.informacion.models.Crud;

import com.vivero.informacion.models.Cliente;

import org.springframework.data.repository.CrudRepository;

/**
 * ClienteCrud
 */
public interface ClienteCrud extends CrudRepository<Cliente, String>{

    
}