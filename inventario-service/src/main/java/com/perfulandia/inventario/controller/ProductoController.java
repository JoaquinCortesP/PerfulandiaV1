package com.perfulandia.inventario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfulandia.inventario.model.Producto;
import com.perfulandia.inventario.repository.ProductoRepository;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // Listar todos los productos
    @GetMapping
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    // Obtener producto por id
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            return ResponseEntity.ok(producto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear nuevo producto
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    // Actualizar producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto productoDetalles) {
        Optional<Producto> productoOptional = productoRepository.findById(id);

        if (!productoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Producto producto = productoOptional.get();
        producto.setNombre(productoDetalles.getNombre());
        producto.setPrecio(productoDetalles.getPrecio());
        producto.setCantidad(productoDetalles.getCantidad());

        Producto productoActualizado = productoRepository.save(producto);
        return ResponseEntity.ok(productoActualizado);
    }

    // Eliminar producto por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        Optional<Producto> productoOptional = productoRepository.findById(id);

        if (!productoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        productoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
