package com.springBootRest.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootRest.model.Producto;
import com.springBootRest.repository.ProductoRepository;




@Service
public class ProductoDao {
	
	@Autowired
	ProductoRepository productoRepository;
	
	public Producto save(Producto pro){
		return  productoRepository.save(pro);
	}
	
	public List<Producto> findAll(){
		return productoRepository.findAll();
	}

	public Producto finOne(Long proid){
		return productoRepository.findOne(proid);
	}
	
	
	public void delete(Producto pro){
		productoRepository.delete(pro);
	}
}
