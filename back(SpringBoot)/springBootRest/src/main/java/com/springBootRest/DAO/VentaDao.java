package com.springBootRest.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootRest.model.Venta;
import com.springBootRest.repository.VentaRepository;


@Service
public class VentaDao {

	@Autowired
	VentaRepository ventaRepository;
	
	public Venta save(Venta per){
		return  ventaRepository.save(per);
	}
	
	public List<Venta> findAll(){
		return ventaRepository.findAll();
	}
	
	public Venta finOne(Long empid){
		return ventaRepository.findOne(empid);
	}
	
	
	public void delete(Venta emp){
		ventaRepository.delete(emp);
	}
}
