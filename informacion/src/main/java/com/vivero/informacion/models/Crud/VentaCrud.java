package com.vivero.informacion.models.Crud;

import com.vivero.informacion.models.Venta;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * VentaCrud
 */
@Repository
public interface VentaCrud extends CrudRepository<Venta, String>{

    public Venta findByDetalleVentaDocumento(String documento);
    public Iterable<Venta> findAll(Pageable page);
}