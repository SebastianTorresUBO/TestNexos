package com.springBootRest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="venta")
@EntityListeners(AuditingEntityListener.class)
public class Venta {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cod_venta;
	
	@NotBlank
	private String producto;
	@NotBlank
	private String cod_cliente;
	@NotBlank
	private String nombre_cliente;
	@NotBlank
	private String apellido_cliente;
	@NotBlank
	private String precio;
	@OneToMany(mappedBy = "id_factura")
	private List<Factura> cod_factura;
	
	
	public Long getCod_venta() {
		return cod_venta;
	}
	public void setCod_venta(Long cod_venta) {
		this.cod_venta = cod_venta;
	}
	
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getCod_cliente() {
		return cod_cliente;
	}
	public void setCod_cliente(String cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public List<Factura> getCod_factura() {
		return cod_factura;
	}
	public void setCod_factura(List<Factura> cod_factura) {
		this.cod_factura = cod_factura;
	}
	public String getApellido_cliente() {
		return apellido_cliente;
	}
	public void setApellido_cliente(String apellido_cliente) {
		this.apellido_cliente = apellido_cliente;
	}
	
	
	
	
	
	
	
}
