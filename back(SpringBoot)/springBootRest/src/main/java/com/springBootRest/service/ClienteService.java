package com.springBootRest.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBootRest.DAO.ClienteDao;

import com.springBootRest.model.Cliente;


@RestController
@RequestMapping("/api-cliente")
public class ClienteService {

	@Autowired
	ClienteDao clienteDao;
	
	@CrossOrigin(origins ="*")
	@PostMapping("/cliente")
	public Cliente crearPersona(@Valid @RequestBody Cliente inv){
		return clienteDao.save(inv);
	}
	
	@CrossOrigin(origins ="*")
	/* tomar todas las personas*/
	@GetMapping("/cliente")
	public List<Cliente> getAllPersons(){
		 return clienteDao.findAll();
	}
	
	@CrossOrigin(origins ="*")
	/* obtener persona por ID*/
	@GetMapping ("/cliente/{id}")
	public ResponseEntity<Cliente> getPersonaById(@PathVariable(value="id") Long empid){
		
		Cliente ciu= clienteDao.finOne(empid);
		if(ciu==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(ciu);
	}
	
	@CrossOrigin(origins ="*")
	/* actualizar persona por id*/
	@PutMapping("/cliente/{id}")
	public ResponseEntity<Cliente> updatePersona(@PathVariable(value="id") Long empid, @Valid @RequestBody Cliente clienteDetalle){
		Cliente per = clienteDao.finOne(empid);
		if(per==null){
			return ResponseEntity.notFound().build();
		}
		
		per.setCod_cliente(clienteDetalle.getCod_cliente());
		per.setNombre(clienteDetalle.getNombre());
		per.setApellido(clienteDetalle.getApellido());
		per.setTelefono(clienteDetalle.getTelefono());
		Cliente actualizarInv= clienteDao.save(per);
		return ResponseEntity.ok().body(per);
		
	}
	
	@DeleteMapping("/cliente/{id}")
	public ResponseEntity<Cliente> deletePersona(@PathVariable(value="id") Long empid){
		Cliente ciu=clienteDao.finOne(empid);
		if (ciu==null){
			return ResponseEntity.notFound().build();
		}
		clienteDao.delete(ciu);
		return ResponseEntity.ok().build();
	}
}
