package com.springBootRest.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootRest.model.Inventario;
import com.springBootRest.repository.InventarioRepository;

@Service
public class InventarioDao {
	
	@Autowired
	InventarioRepository inventarioRepository;
	/* guardar Persona */
	public Inventario save(Inventario per){
		return  inventarioRepository.save(per);
	}
	/* Buscar Persona */
	public List<Inventario> findAll(){
		return inventarioRepository.findAll();
	}
	/* Buscar Persona por ID */
	public Inventario finOne(Long empid){
		return inventarioRepository.findOne(empid);
	}
	/* borrar Persona por ID*/
	
	public void delete(Inventario emp){
		inventarioRepository.delete(emp);
	}
}
