package com.springBootRest.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootRest.model.Factura;

import com.springBootRest.repository.FacturaRepository;


@Service
public class FacturaDao {

	@Autowired
	FacturaRepository facturaRepository;
	
	public Factura save(Factura per){
		return  facturaRepository.save(per);
	}

	public List<Factura> findAll(){
		return facturaRepository.findAll();
	}
	
	public Factura finOne(Long empid){
		return facturaRepository.findOne(empid);
	}
	
	
	public void delete(Factura emp){
		facturaRepository.delete(emp);
	}
}
