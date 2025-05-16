package com.perfulandia.inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.perfulandia.inventario.repository")
@EntityScan(basePackages = "com.perfulandia.inventario.model")

public class InventarioServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioServiceApplication.class, args);
	}

}
