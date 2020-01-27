package com.springBootRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springBootRest.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {

}
