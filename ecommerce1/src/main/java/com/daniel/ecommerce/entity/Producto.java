package com.daniel.ecommerce.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 13)
	private Long ean;

	@Column(nullable = false, length = 60)
	private String nombre;

	@Column(nullable = false)
	private String descripcion;
	@Column(nullable = false, length = 60)
	private String marca;
	@Column(nullable = false)
	private Long unidades;

	@Column(nullable = true, length = 10000)
	private String photos;

	@Column(nullable = false)
	private  Long precio;
	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
	private List<Comentario> comentarios;

	public Producto() {
	}

	public Producto(Long id, Long ean, String nombre, String descripcion, String marca, Long unidades, String photos, Long precio, List<Comentario> comentarios) {
		this.id = id;
		this.ean = ean;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.marca = marca;
		this.unidades = unidades;
		this.photos = photos;
		this.precio = precio;
		this.comentarios = comentarios;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEan() {
		return ean;
	}

	public void setEan(Long ean) {
		this.ean = ean;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Long getUnidades() {
		return unidades;
	}

	public void setUnidades(Long unidades) {
		this.unidades = unidades;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
}
