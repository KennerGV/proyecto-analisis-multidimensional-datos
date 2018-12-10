package com.vivero.informacion.models.Crud;

import com.vivero.informacion.models.Articulo;

import org.springframework.data.repository.CrudRepository;

/**
 * ArticuloCrud
 */
public interface ArticuloCrud extends CrudRepository<Articulo, String>{

    
}