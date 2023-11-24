package com.daniel.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.ecommerce.entity.Producto;
import com.daniel.ecommerce.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	public List<Producto> listAll(String palabraClave){
		if(palabraClave !=null) {
			return productoRepository.findAll(palabraClave);
		}
		return productoRepository.findAll();
	}


	public void save(Producto producto) {
		productoRepository.save(producto);
	}

	public Producto get(Long id) {
		return productoRepository.findById(id).get();

	}

	public void delete(Long id) {
		productoRepository.deleteById(id);

	}


}
