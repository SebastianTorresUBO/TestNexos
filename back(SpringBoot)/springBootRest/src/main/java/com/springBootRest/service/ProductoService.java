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
import com.springBootRest.DAO.ProductoDao;
import com.springBootRest.model.Inventario;
import com.springBootRest.model.Producto;

import javassist.expr.NewArray;

@RestController
@RequestMapping("/api-producto")
public class ProductoService {
	@Autowired
	ProductoDao productoDao;
	
	@Autowired
	InventarioDao inventarioDao;
	
	@CrossOrigin(origins ="*")
	@PostMapping("/producto")
	public Producto crearProducto(@Valid @RequestBody Producto pro){
		/*Inventario inv= new Inventario();
		inv.setCod_producto(pro.getCod_producto().get(0).getCod_producto());
		inv.setStock(pro.getCod_producto().get(0).getStock());
		
		inventarioDao.save(inv);*/
		return productoDao.save(pro);
	}
	
	@CrossOrigin(origins ="*")
	/* tomar todas las personas*/
	@GetMapping("/producto")
	public List<Producto> getAllProductos(){
		 return productoDao.findAll();
	}
	
	@CrossOrigin(origins ="*")
	/* obtener persona por ID*/
	@GetMapping ("/producto/{id}")
	public ResponseEntity<Producto> getProductoById(@PathVariable(value="id") Long empid){
		
		Producto ciu= productoDao.finOne(empid);
		if(ciu==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(ciu);
	}
	
	@CrossOrigin(origins ="*")
	/* actualizar persona por id*/
	@PutMapping("/producto/{id}")
	public ResponseEntity<Producto> updateProducto(@PathVariable(value="id") Long empid, @Valid @RequestBody Producto productoDetalle){
		Producto per = productoDao.finOne(empid);
		Inventario inv= inventarioDao.finOne(empid);
		if(per==null){
			return ResponseEntity.notFound().build();
		}
		per.setCod_producto(productoDetalle.getCod_producto());
		per.setPrecio(productoDetalle.getPrecio());
		per.setNombre(productoDetalle.getNombre());
		
		if(inv==null) {
			return ResponseEntity.notFound().build();
		}
		inv.setStock(productoDetalle.getCod_producto().get(0).getStock());
		
		Producto actualizarPro= productoDao.save(per);
		return ResponseEntity.ok().body(per);
		
	}
	
	@DeleteMapping("/producto/{id}")
	public ResponseEntity<Producto> deleteProducto(@PathVariable(value="id") Long empid){
		Producto ciu=productoDao.finOne(empid);
		if (ciu==null){
			return ResponseEntity.notFound().build();
		}
		productoDao.delete(ciu);
		return ResponseEntity.ok().build();
	}
}
