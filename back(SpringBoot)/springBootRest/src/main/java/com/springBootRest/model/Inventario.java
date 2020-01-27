package com.springBootRest.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="inventario")
@EntityListeners(AuditingEntityListener.class)
public class Inventario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; 

	private Long cod_producto;
	@NotBlank
	private String stock;
	@NotBlank
	private String precio;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCod_producto() {
		return cod_producto;
	}
	public void setCod_producto(Long cod_producto) {
		this.cod_producto = cod_producto;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	
}
