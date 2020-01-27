package com.springBootRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springBootRest.model.Producto;

public interface ProductoRepository  extends JpaRepository<Producto, Long>{
 
}
