package com.springBootRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBootRest.model.Factura;


public interface FacturaRepository extends JpaRepository<Factura, Long> {

}
