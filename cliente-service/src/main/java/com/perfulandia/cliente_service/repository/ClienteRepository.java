package com.perfulandia.cliente_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.perfulandia.cliente_service.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
