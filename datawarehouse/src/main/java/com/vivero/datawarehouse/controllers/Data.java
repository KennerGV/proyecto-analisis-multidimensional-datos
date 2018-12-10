package com.vivero.datawarehouse.controllers;

import java.util.HashMap;
import java.util.Map;

import com.vivero.datawarehouse.models.Cliente;
import com.vivero.datawarehouse.models.Producto;
import com.vivero.datawarehouse.models.Sucursal;
import com.vivero.datawarehouse.models.Tiempo;
import com.vivero.datawarehouse.models.Vendedor;
import com.vivero.datawarehouse.models.Venta;
import com.vivero.datawarehouse.models.crud.ClienteCrud;
import com.vivero.datawarehouse.models.crud.ProductoCrud;
import com.vivero.datawarehouse.models.crud.SucursalCrud;
import com.vivero.datawarehouse.models.crud.TiempoCrud;
import com.vivero.datawarehouse.models.crud.VendedorCrud;
import com.vivero.datawarehouse.models.crud.VentaCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Data
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/save")
public class Data {

    @Autowired
    private ClienteCrud clienteCrud;

    @Autowired
    private ProductoCrud productoCrud;

    @Autowired
    private SucursalCrud sucursalCrud;

    @Autowired
    private TiempoCrud tiempoCrud;

    @Autowired
    private VendedorCrud vendedorCrud;

    @Autowired
    private VentaCrud ventaCrud;

    @PostMapping("/cliente")
    public Cliente guardarCliente(@RequestBody Cliente cliente){
        return clienteCrud.save(cliente);
    }

    @PostMapping("/producto")
    public Producto guardarProducto(@RequestBody Producto producto){
        return productoCrud.save(producto);
    }

    @PostMapping("/sucursal")
    public Sucursal guardarSucursal(@RequestBody Sucursal sucursal){
        return sucursalCrud.save(sucursal);
    }

    @PostMapping("/tiempo")
    public Tiempo guardarTiempo(@RequestBody Tiempo tiempo){
        return tiempoCrud.save(tiempo);
    }

    @PostMapping("/vendedor")
    public Vendedor guardarVendedor(@RequestBody Vendedor vendedor){
        return vendedorCrud.save(vendedor);
    }

    @PostMapping("/venta")
    public Venta guardarVenta(@RequestBody Venta venta){
        return ventaCrud.save(venta);
    }
    @GetMapping("/venta")
    public Iterable<Venta> ventas(@RequestParam(name = "page", defaultValue = "0") int page){
        //numero de pagina y cantidad de elementos
        Pageable pageRequest = PageRequest.of(page, 50);
        return ventaCrud.findAll(pageRequest);
    }
   
    @GetMapping("/ventaAll")
    public Iterable<Venta> ventas(){
        return ventaCrud.findAll();
    }
   /*  @PostMapping("/guardarCliente") 
    public Map<String, String> guardarCliente(@RequestBody List<Cliente> cliente){
        for(Cliente clien : cliente){
            clienteCrud.save(clien);
        }
        
        return respuesta();
    } */
    public Map<String, String> respuesta(){
        HashMap<String, String> respuesta = new HashMap<>();
        respuesta.put("guardado", "bien");
        System.out.println(respuesta.get("guardado"));
        return respuesta;
    }
}