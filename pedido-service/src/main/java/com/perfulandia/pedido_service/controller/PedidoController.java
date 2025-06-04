package com.perfulandia.pedido_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfulandia.pedido_service.model.Pedido;
import com.perfulandia.pedido_service.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<Pedido> listar() {
        return pedidoService.listarPedidos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obtenerPorId(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoService.obtenerPorId(id);
        return pedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pedido crear(@RequestBody Pedido pedido) {
        return pedidoService.guardarPedido(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pedidoService.eliminarPedido(id);
        return ResponseEntity.noContent().build();
    }
}