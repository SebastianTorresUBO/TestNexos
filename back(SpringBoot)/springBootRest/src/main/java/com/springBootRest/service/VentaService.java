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

import com.springBootRest.DAO.VentaDao;
import com.springBootRest.model.Venta;



@RestController
@RequestMapping("/api-venta")
public class VentaService {
	@Autowired
	VentaDao ventaDao;
	
	@CrossOrigin(origins ="*")
	@PostMapping("/venta")
	public Venta crearVenta(@Valid @RequestBody Venta pro){
		return ventaDao.save(pro);
	}
	
	@CrossOrigin(origins ="*")
	/* tomar todas las personas*/
	@GetMapping("/venta")
	public List<Venta> getAllPersons(){
		 return ventaDao.findAll();
	}
	
	@CrossOrigin(origins ="*")
	/* obtener persona por ID*/
	@GetMapping ("/venta/{id}")
	public ResponseEntity<Venta> getVentaById(@PathVariable(value="id") Long empid){
		
		Venta ciu= ventaDao.finOne(empid);
		if(ciu==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(ciu);
	}
	
	@CrossOrigin(origins ="*")
	/* actualizar persona por id*/
	@PutMapping("/venta/{id}")
	public ResponseEntity<Venta> updateVenta(@PathVariable(value="id") Long empid, @Valid @RequestBody Venta ventaDetalle){
		Venta per = ventaDao.finOne(empid);
		if(per==null){
			return ResponseEntity.notFound().build();
		}
		per.setCod_cliente(ventaDetalle.getCod_cliente());
		per.setPrecio(ventaDetalle.getPrecio());
		per.setNombre_cliente(ventaDetalle.getNombre_cliente());
		per.setApellido_cliente(ventaDetalle.getApellido_cliente());
		per.setProducto(ventaDetalle.getProducto());
		
		Venta actualizarPro= ventaDao.save(per);
		return ResponseEntity.ok().body(per);
		
	}
	
	@DeleteMapping("/venta/{id}")
	public ResponseEntity<Venta> deleteVenta(@PathVariable(value="id") Long empid){
		Venta ciu=ventaDao.finOne(empid);
		if (ciu==null){
			return ResponseEntity.notFound().build();
		}
		ventaDao.delete(ciu);
		return ResponseEntity.ok().build();
	}
}
