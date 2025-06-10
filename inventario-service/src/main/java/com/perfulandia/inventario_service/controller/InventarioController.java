package com.perfulandia.inventario_service.controller;

import com.perfulandia.inventario_service.model.Inventario;
import com.perfulandia.inventario_service.service.InventarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    private final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping
    public List<Inventario> listarTodos() {
        return inventarioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> obtenerPorId(@PathVariable Long id) {
        return inventarioService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Inventario> crear(@Valid @RequestBody Inventario inventario) {
        return ResponseEntity.ok(inventarioService.guardar(inventario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        inventarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}