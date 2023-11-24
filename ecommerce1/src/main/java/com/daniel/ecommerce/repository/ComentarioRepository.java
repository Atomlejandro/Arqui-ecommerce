package com.daniel.ecommerce.repository;

import com.daniel.ecommerce.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByProductoId(Long productoId);
}