package com.perfulandia.inventario_service.repository;

import com.perfulandia.inventario_service.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
}