package com.app.spring.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.spring.repository.ClienteRepository;
import com.app.spring.entity.Cliente;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> lista(){
		return clienteRepository.listaPlsql();
	}
	
	public Optional<Cliente> getById(int id){
		return clienteRepository.idPlsql(id);
	}
	
	public void savePlsql(Cliente cliente){
		clienteRepository.savePlsql(cliente.getNombre(), cliente.getApellido(), cliente.getDni(), cliente.getFec_nac());
	} 
	
	public void borrarPlsql(int id){
        clienteRepository.borrarPlsql(id);
    }

}
