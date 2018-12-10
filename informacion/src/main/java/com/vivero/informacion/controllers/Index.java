package com.vivero.informacion.controllers;

import com.vivero.informacion.models.Articulo;
import com.vivero.informacion.models.Cliente;
import com.vivero.informacion.models.DetalleVenta;
import com.vivero.informacion.models.Sucursal;
import com.vivero.informacion.models.Vendedor;
import com.vivero.informacion.models.Venta;
import com.vivero.informacion.models.Crud.ArticuloCrud;
import com.vivero.informacion.models.Crud.ClienteCrud;
import com.vivero.informacion.models.Crud.SucursalCrud;
import com.vivero.informacion.models.Crud.VendedorCrud;
import com.vivero.informacion.models.Crud.VentaCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Index
 */
@CrossOrigin(origins = "*")
@RestController
public class Index {
    @Autowired
    private ArticuloCrud articuloCrud;

    @Autowired
    private ClienteCrud clienteCrud;

    @Autowired
    private SucursalCrud sucursalCrud;

    @Autowired
    private VendedorCrud vendedorCrud;

    @Autowired
    private VentaCrud ventaCrud;

    @GetMapping("/articulo")
    public Iterable<Articulo> listArticulos(){
        return articuloCrud.findAll();
    }

    @GetMapping("/cliente")
    public Iterable<Cliente> listClientes(){
        return clienteCrud.findAll();
    }

    @GetMapping("/sucursal")
    public Iterable<Sucursal> listSucursal(){
        return sucursalCrud.findAll();
    }

    @GetMapping("/vendedor")
    public Iterable<Vendedor> listVendedores(){
        return vendedorCrud.findAll();
    }
    @GetMapping("/venta")
    public Iterable<Venta> listVentas(){
        return ventaCrud.findAll();
    }

   
    @GetMapping("/pagination")
    public Iterable<Venta> listPaginada(@RequestParam(name = "page", defaultValue = "0") int page){
        /* long count = ventaCrud.count();
        int pageSize = 10;
        long pages = count/pageSize; */
        /* for(int i = 0; i< pages; i++){
            
        } */
        //numero de pagina y cantidad de elementos
        Pageable pageRequest = PageRequest.of(page, 500);
        return ventaCrud.findAll(pageRequest);
    }
}