package com.springBootRest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="producto")
@EntityListeners(AuditingEntityListener.class)
public class Producto {
	
	@Id
	private Long id;
	@OneToMany (mappedBy = "cod_producto")
	private List<Inventario> cod_producto;
	@NotBlank
	private String nombre;
	@NotBlank
	private String precio;
	

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Inventario> getCod_producto() {
		return cod_producto;
	}
	public void setCod_producto(List<Inventario> cod_producto) {
		this.cod_producto = cod_producto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	
	
	
}
