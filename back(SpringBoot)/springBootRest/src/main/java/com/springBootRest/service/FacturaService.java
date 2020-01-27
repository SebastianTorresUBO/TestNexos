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

import com.springBootRest.DAO.FacturaDao;
import com.springBootRest.model.Factura;



@RestController
@RequestMapping("/api-factura")
public class FacturaService {
	@Autowired
	FacturaDao facturaDao;
	
	@CrossOrigin(origins ="*")
	@PostMapping("/factura")
	public Factura crearPersona(@Valid @RequestBody Factura inv){
		return facturaDao.save(inv);
	}
	
	@CrossOrigin(origins ="*")

	@GetMapping("/factura")
	public List<Factura> getAllPersons(){
		 return facturaDao.findAll();
	}
	
	@CrossOrigin(origins ="*")

	@GetMapping ("/factura/{id}")
	public ResponseEntity<Factura> getPersonaById(@PathVariable(value="id") Long empid){
		
		Factura ciu= facturaDao.finOne(empid);
		if(ciu==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(ciu);
	}
	
	@CrossOrigin(origins ="*")

	@PutMapping("/factura/{id}")
	public ResponseEntity<Factura> updatePersona(@PathVariable(value="id") Long empid, @Valid @RequestBody Factura facturaDetalle){
		Factura per = facturaDao.finOne(empid);
		if(per==null){
			return ResponseEntity.notFound().build();
		}
		per.setCod_cliente(facturaDetalle.getCod_cliente());
		per.setNombre_cliente(facturaDetalle.getNombre_cliente());
		per.setApellido_cliente(facturaDetalle.getApellido_cliente());
		per.setPrecio(facturaDetalle.getPrecio());
		per.setProducto(facturaDetalle.getProducto());
		
		Factura actualizarInv= facturaDao.save(per);
		return ResponseEntity.ok().body(per);
		
	}
	
	@DeleteMapping("/factura/{id}")
	public ResponseEntity<Factura> deletePersona(@PathVariable(value="id") Long empid){
		Factura ciu=facturaDao.finOne(empid);
		if (ciu==null){
			return ResponseEntity.notFound().build();
		}
		facturaDao.delete(ciu);
		return ResponseEntity.ok().build();
	}
}
