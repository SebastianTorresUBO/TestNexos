package com.springBootRest.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootRest.model.Cliente;
import com.springBootRest.repository.ClienteRepository;



@Service
public class ClienteDao {

	@Autowired
	ClienteRepository clienteRepository;
	/* guardar Persona */
	public Cliente save(Cliente per){
		return  clienteRepository.save(per);
	}
	/* Buscar Persona */
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	/* Buscar Persona por ID */
	public Cliente finOne(Long empid){
		return clienteRepository.findOne(empid);
	}
	/* borrar Persona por ID*/
	
	public void delete(Cliente emp){
		clienteRepository.delete(emp);
	}
}
