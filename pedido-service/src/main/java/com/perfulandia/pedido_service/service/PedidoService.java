package com.perfulandia.pedido_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.perfulandia.pedido_service.model.Pedido;
import com.perfulandia.pedido_service.repository.PedidoRepository;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> obtenerPorId(Long id) {
        return pedidoRepository.findById(id);
    }
    public Pedido guardarPedido(Pedido pedido) {
        if(pedido.getDetalles() != null){
        pedido.getDetalles().forEach(d -> d.setPedido(pedido));
        }
        return pedidoRepository.save(pedido);
    }

    public void eliminarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}