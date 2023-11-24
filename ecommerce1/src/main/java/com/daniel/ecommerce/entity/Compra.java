package com.daniel.ecommerce.entity;

import jakarta.persistence.*;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    private String nombreCliente;
    private String direccion;
    private String tipoTarjeta;
    private Long precio;

    private Long cantidad;

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Long getPrecio() {
        return precio;
    }
    public Compra() {
    }

    public Compra(Long id, Producto producto, String nombreCliente, String direccion, String tipoTarjeta, Long cantidad) {
        this.id = id;
        this.producto = producto;
        this.nombreCliente = nombreCliente;
        this.direccion = direccion;
        this.tipoTarjeta = tipoTarjeta;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public Long getCantidad(){ return cantidad;}
    public void setCantidad(Integer cantidad) {
    }
}
