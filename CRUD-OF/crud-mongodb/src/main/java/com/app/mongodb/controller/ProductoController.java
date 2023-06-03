package com.app.mongodb.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.mongodb.model.Producto;
import com.app.mongodb.repo.ProductoRepository;

@CrossOrigin
@RestController
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	private ProductoRepository productoRepository;
	
	@GetMapping("")
	List<Producto> index() {
		return productoRepository.findAll();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	Producto create(@RequestBody Producto producto) {
		return productoRepository.save(producto);
	}
	
	
	@PutMapping("{id}")
	Producto update(@PathVariable String id,@RequestBody Producto producto) {
		Producto productoFromDb = productoRepository
				.findById(id)
				.orElseThrow(RuntimeException::new);
		
		productoFromDb.setCategoria(producto.getCategoria());
		productoFromDb.setNombre(producto.getNombre());
		productoFromDb.setPrecio(producto.getPrecio());
		productoFromDb.setStock(producto.getStock());
		
		return productoRepository.save(productoFromDb);	
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	void delete(@PathVariable String id) {
		Producto producto = productoRepository
				.findById(id)
				.orElseThrow(RuntimeException::new);
		
		productoRepository.delete(producto);
	}
	
	
}
