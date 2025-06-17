package com.perfulandia.producto_service.config;

import com.perfulandia.producto_service.model.Producto;
import com.perfulandia.producto_service.repository.ProductoRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;
import java.util.stream.IntStream;

@Configuration
public class DataFakerLoader {

    @Bean
    public CommandLineRunner initData(ProductoRepository productoRepository) {
        return args -> {
            long count = productoRepository.count();

            if (count < 15) {
                Faker faker = new Faker(new Locale("es"));
                IntStream.rangeClosed(6, 20).forEach(i -> {
                    Producto producto = new Producto();
                    producto.setNombre(faker.commerce().productName());
                    producto.setCodigoBarras(faker.number().digits(13));
                    producto.setMililitros(faker.number().numberBetween(50, 500));
                    producto.setProveedor(faker.company().name());
                    producto.setTipo(faker.commerce().material());
                    producto.setStock(faker.number().numberBetween(5, 100));

                    productoRepository.save(producto);
                });
            }
        };
    }
}
