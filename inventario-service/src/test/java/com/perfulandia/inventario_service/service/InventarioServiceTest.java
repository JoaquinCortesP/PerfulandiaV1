package com.perfulandia.inventario_service.service;

import com.perfulandia.inventario_service.model.Inventario;
import com.perfulandia.inventario_service.repository.InventarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InventarioServiceTest {

    private InventarioRepository inventarioRepository;
    private InventarioService inventarioService;

    @BeforeEach
    void setUp() {
        inventarioRepository = mock(InventarioRepository.class);
        inventarioService = new InventarioService(inventarioRepository);
    }

    @Test
    void obtenerTodos_debeRetornarListaInventarios() {
        Inventario inv1 = new Inventario();
        Inventario inv2 = new Inventario();
        List<Inventario> inventarios = Arrays.asList(inv1, inv2);

        when(inventarioRepository.findAll()).thenReturn(inventarios);

        List<Inventario> resultado = inventarioService.obtenerTodos();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        verify(inventarioRepository, times(1)).findAll();
    }

    @Test
    void obtenerPorId_cuandoExiste_retornaInventario() {
        Inventario inventario = new Inventario();
        inventario.setId(1L);

        when(inventarioRepository.findById(1L)).thenReturn(Optional.of(inventario));

        Optional<Inventario> resultado = inventarioService.obtenerPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals(1L, resultado.get().getId());
        verify(inventarioRepository, times(1)).findById(1L);
    }

    @Test
    void obtenerPorId_cuandoNoExiste_retornaEmpty() {
        when(inventarioRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Inventario> resultado = inventarioService.obtenerPorId(1L);

        assertFalse(resultado.isPresent());
        verify(inventarioRepository, times(1)).findById(1L);
    }

    @Test
    void guardar_debeGuardarYRetornarInventario() {
        Inventario inventario = new Inventario();

        when(inventarioRepository.save(ArgumentMatchers.any(Inventario.class))).thenReturn(inventario);

        Inventario resultado = inventarioService.guardar(inventario);

        assertNotNull(resultado);
        verify(inventarioRepository, times(1)).save(inventario);
    }

    @Test
    void eliminar_debeEliminarPorId() {
        doNothing().when(inventarioRepository).deleteById(1L);

        inventarioService.eliminar(1L);

        verify(inventarioRepository, times(1)).deleteById(1L);
    }
}

