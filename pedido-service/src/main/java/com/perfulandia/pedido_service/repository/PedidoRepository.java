package com.perfulandia.pedido_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.pedido_service.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {}