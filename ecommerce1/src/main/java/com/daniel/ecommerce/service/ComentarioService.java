package com.daniel.ecommerce.service;

import com.daniel.ecommerce.entity.Comentario;
import com.daniel.ecommerce.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Comentario> getComentariosByProductoId(Long productoId) {
        return comentarioRepository.findByProductoId(productoId);
    }

    public void guardarComentario(Comentario comentario) {
        comentarioRepository.save(comentario);
    }
    public List<Comentario> getComentariosOrdenadosPorFecha(Long productoId) {
        // Obtener los comentarios relacionados con el producto
        List<Comentario> comentarios = comentarioRepository.findByProductoId(productoId);

        // Ordenar los comentarios por fecha (el más reciente primero)
        comentarios.sort(Comparator.comparing(Comentario::getFecha).reversed());

        return comentarios;
    }
}
