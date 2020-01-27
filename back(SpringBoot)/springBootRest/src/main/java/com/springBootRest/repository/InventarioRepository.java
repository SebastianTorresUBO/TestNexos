package com.springBootRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBootRest.model.Inventario;


public interface InventarioRepository  extends JpaRepository<Inventario, Long>{

}
