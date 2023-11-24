package com.daniel.ecommerce.service;

import com.daniel.ecommerce.entity.Compra;
import com.daniel.ecommerce.entity.Producto;
import com.daniel.ecommerce.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    @Autowired
    private static CompraRepository compraRepository;

    @Autowired
    private static ProductoService productoService;

    public void guardarCompra(Compra compra) {

        // Obtener el producto relacionado con la compra
        Producto producto = compra.getProducto();

        // Disminuir una unidad del producto comprado
        if (producto.getUnidades() < compra.getCantidad()) {
            throw new RuntimeException("No hay suficientes unidades disponibles");
        }
        producto.setUnidades(producto.getUnidades() - compra.getCantidad());
        productoService.save(producto); // Guardar el producto actualizado

        // Guardar los detalles de la compra
        compraRepository.save(compra);
    }

    // Otras operaciones relacionadas con compras...

}
