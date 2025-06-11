package com.perfulandia.producto_service.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.producto_service.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Optional<Producto> findByCodigoBarras(String codigoBarras);
}
