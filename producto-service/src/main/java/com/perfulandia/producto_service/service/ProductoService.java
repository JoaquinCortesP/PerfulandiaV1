package com.perfulandia.producto_service.service;

import java.util.List;
import java.util.Optional;

import com.perfulandia.producto_service.model.Producto;

public interface ProductoService {
    Producto crearProducto(Producto producto);
    List<Producto> listarProductos();
    Optional<Producto> obtenerPorId(Long id);
    Optional<Producto> obtenerPorCodigoBarras(String codigoBarras);
    Producto actualizarProducto(Long id, Producto producto);
    void eliminarProducto(Long id);
}