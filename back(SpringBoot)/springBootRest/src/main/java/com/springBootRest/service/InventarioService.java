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

import com.springBootRest.DAO.InventarioDao;
import com.springBootRest.model.Inventario;

@RestController
@RequestMapping("/api-inventario")
public class InventarioService {
	
	@Autowired
	InventarioDao inventarioDao;
	
	@CrossOrigin(origins ="*")
	@PostMapping("/inventario")
	public Inventario crearPersona(@Valid @RequestBody Inventario inv){
		return inventarioDao.save(inv);
	}
	
	@CrossOrigin(origins ="*")
	/* tomar todas las personas*/
	@GetMapping("/inventario")
	public List<Inventario> getAllInventario(){
		 return inventarioDao.findAll();
	}
	
	@CrossOrigin(origins ="*")
	/* obtener persona por ID*/
	@GetMapping ("/inventario/{cod_producto}")
	public ResponseEntity<Inventario> getInventarioById(@PathVariable(value="cod_producto") Long empid){
		
		Inventario ciu= inventarioDao.finOne(empid);
		if(ciu==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(ciu);
	}
	
	@CrossOrigin(origins ="*")
	/* actualizar persona por id*/
	@PutMapping("/inventario/{id}")
	public ResponseEntity<Inventario> updateInventario(@PathVariable(value="id") Long empid, @Valid @RequestBody Inventario inventarioDetalle){
		Inventario per = inventarioDao.finOne(empid);
		if(per==null){
			return ResponseEntity.notFound().build();
		}
		per.setCod_producto(inventarioDetalle.getCod_producto());
		per.setId(inventarioDetalle.getId());
		per.setPrecio(inventarioDetalle.getPrecio());
		per.setStock(inventarioDetalle.getStock());
		
		Inventario actualizarInv= inventarioDao.save(per);
		return ResponseEntity.ok().body(per);
		
	}
	
	@DeleteMapping("/inventario/{id}")
	public ResponseEntity<Inventario> deleteInventario(@PathVariable(value="id") Long empid){
		Inventario ciu=inventarioDao.finOne(empid);
		if (ciu==null){
			return ResponseEntity.notFound().build();
		}
		inventarioDao.delete(ciu);
		return ResponseEntity.ok().build();
	}
	
}
