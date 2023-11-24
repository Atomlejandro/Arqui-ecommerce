package com.daniel.ecommerce.controllers;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import com.daniel.ecommerce.entity.Comentario;
import com.daniel.ecommerce.repository.ProductoRepository;
import com.daniel.ecommerce.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.daniel.ecommerce.entity.Producto;
import com.daniel.ecommerce.service.ProductoService;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private ComentarioService comentarioService;




	@RequestMapping("/")
	public String verPaginaDeInicio(Model model, @Param("String palabraClave")String palabraClave) {

		List<Producto> listaProdcutos = productoService.listAll(palabraClave);


		model.addAttribute("listaProductos", listaProdcutos);
		model.addAttribute("palabraClave", palabraClave);

		return "index";

	}

	@GetMapping("/producto/{id}")
	public String mostrarProducto(@PathVariable Long id, Model model) {

		// Recuperar el producto del repositorio usando el ID
		Producto producto = productoService.get(id);
		List<Comentario> comentarios = comentarioService.getComentariosByProductoId(id);

		// Agregar el producto al modelo y mostrar la vista con detalles
		model.addAttribute("producto", producto);
		model.addAttribute("comentarios", comentarios);

		return "detalles-producto"; // Nombre de la vista que muestra los detalles del producto
	}

	@RequestMapping("/nuevo")
	public String mostrarFormularioDeRegistrar(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto",producto);
		return "nuevo_producto";

	}

	@PostMapping("/guardar")
	public String guardarProducto(@ModelAttribute("producto") Producto producto, Model model, @RequestParam("photos")MultipartFile photos) {

		if (photos.isEmpty()) {
			return "redirect:/";
		}

		// Guardar la foto del producto
		String photosPath = "uploads/" + photos.getOriginalFilename();
		try {
			photos.transferTo(new File(photosPath));
		} catch (IOException e) {
			e.printStackTrace();
			return "redirect:/";
		}

		// Actualizar la propiedad photos del objeto Producto
		producto.setPhotos(photosPath);

		productoService.save(producto);

		return "redirect:/";

	}

	@PostMapping("/producto/{id}/comentario")
	public String agregarComentario(@PathVariable Long id, @RequestParam("texto") String texto) {
		// Obtener el producto
		Producto producto = productoService.get(id);

		// Crear un nuevo comentario
		Comentario comentario = new Comentario();
		comentario.setProducto(producto);
		comentario.setTexto(texto);
		comentario.setFecha(LocalDateTime.now());

		// Guardar el comentario usando el servicio
		comentarioService.guardarComentario(comentario);

		// Redireccionar de vuelta a la página de detalles del producto
		return "redirect:/producto/" + id;
	}



}


	/*	<div class="form-group">
						<label>Foto:</label>
						<input type="file" name="photos"  accept="image/png, image/jpeg" th:field="*{photos}" class="form-control" required>
					</div>*/

	/*	<td th:text="${producto.photos}"></td>*/
