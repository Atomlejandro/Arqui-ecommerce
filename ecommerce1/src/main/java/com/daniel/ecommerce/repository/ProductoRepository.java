package com.daniel.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.daniel.ecommerce.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {


	@Query("SELECT p FROM Producto p WHERE CONCAT(p.id, p.nombre, p.marca, p.ean) LIKE %:palabraClave%")
	public List<Producto> findAll(@Param("palabraClave") String palabraClave);

}
