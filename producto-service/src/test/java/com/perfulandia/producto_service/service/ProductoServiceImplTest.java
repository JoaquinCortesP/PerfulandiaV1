package com.perfulandia.producto_service.service;

import com.perfulandia.producto_service.model.Producto;
import com.perfulandia.producto_service.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductoServiceImplTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoServiceImpl productoService;

    private Producto producto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        producto = Producto.builder()
                .id(1L)
                .nombre("Perfume Azul")
                .mililitros(100)
                .codigoBarras("ABC123")
                .proveedor("Fragancias S.A.")
                .tipo("Perfume")
                .stock(10)
                .build();
    }

    @Test
    void testCrearProducto() {
        when(productoRepository.save(any(Producto.class))).thenReturn(producto);

        Producto resultado = productoService.crearProducto(producto);

        assertEquals("Perfume Azul", resultado.getNombre());
        assertEquals("ABC123", resultado.getCodigoBarras());
        verify(productoRepository, times(1)).save(producto);
    }
}
