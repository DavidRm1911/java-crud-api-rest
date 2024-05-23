package pe.upc.estudiando2.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.upc.estudiando2.entities.Producto;
import pe.upc.estudiando2.repositories.ProductoRepository;

import java.util.List;


@RestController
@RequestMapping("/productos")
public class ProductoController {

    //CRUD
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id){
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto detallesProducto){
       Producto producto = productoRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto.setNombre(detallesProducto.getNombre());
        producto.setPrecio(detallesProducto.getPrecio());

        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable Long id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        productoRepository.delete(producto);
        return "Producto eliminado" + id + "fue eliminado";
    }

}
