package com.app.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.spring.entity.Cliente;
import com.app.spring.service.ClienteService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Cliente>> lista(){
		List<Cliente> lista = clienteService.lista();
		return new ResponseEntity(lista, HttpStatus.OK);
	}
	
	@GetMapping("/verid/{id}")
	public ResponseEntity<Cliente> verId(@PathVariable("id") int id){
		Optional<Cliente> cliente = clienteService.getById(id);
		return new ResponseEntity(cliente,HttpStatus.OK);
	}
	
	@PostMapping("/nuevo")
	public ResponseEntity<?> save(@RequestBody Cliente cliente){
		clienteService.savePlsql(cliente);
		return new ResponseEntity("Cliente Registrado", HttpStatus.CREATED);
	}
	
	@DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrar(@PathVariable("id")int id){
        clienteService.borrarPlsql(id);
        return new ResponseEntity("Cliente elimindo", HttpStatus.OK);
    }
	

}
