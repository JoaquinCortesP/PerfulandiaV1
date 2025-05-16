package com.perfulandia.inventario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false, unique = true)
    private String nombre;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 0, message = "La cantidad debe ser 0 o mayor")
    private Integer cantidad;

    @NotNull(message = "El precio es obligatorio")
    @Min(value = 0, message = "El precio debe ser 0 o mayor")
    private Double precio;

    @NotBlank(message = "El proveedor es obligatorio")
    private String proveedor;

    @NotBlank(message = "La categoría es obligatoria")
    private String categoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    // Constructor vacío
    public Producto() {}

    // Constructor con parámetros
    public Producto(String nombre, Integer cantidad, Double precio,
                    String proveedor, String categoria, String codigoBarras) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.proveedor = proveedor;
        this.categoria = categoria;
        this.codigoBarras = codigoBarras;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
}
