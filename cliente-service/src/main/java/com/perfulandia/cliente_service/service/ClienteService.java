package com.perfulandia.cliente_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.perfulandia.cliente_service.model.Cliente;
import com.perfulandia.cliente_service.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente actualizarCliente(Long id, Cliente detalles) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNombre(detalles.getNombre());
                    cliente.setEmail(detalles.getEmail());
                    cliente.setDireccion(detalles.getDireccion());
                    cliente.setTelefono(detalles.getTelefono());
                    cliente.setDni(detalles.getDni());
                    return clienteRepository.save(cliente);
                }).orElse(null);
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
