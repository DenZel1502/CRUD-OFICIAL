package com.app.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.spring.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	@Query(value = "{ call lista_Plql()}", nativeQuery = true)
	List<Cliente> listaPlsql();
	
	@Query(value = "{ call id_Plsql(:idIn)}", nativeQuery= true)
	Optional<Cliente> idPlsql(@Param("idIn")int idIN);
	
	@Query(value = "{call save_Plsql(:nombreIn, :apellidoIn, :dniIn, :fec_nacIn)}", nativeQuery= true)
	void savePlsql(
			@Param("nombreIn")String marcaIn,
			@Param("apellidoIn")String apellidoIn,
			@Param("dniIn")String dniIn,
			@Param("fec_nacIn")String fec_nacIn
			);
	
	@Query(value = "{call borrar_Plsql(:idIn)}", nativeQuery = true)
    void borrarPlsql(@Param("idIn") int idIN);
}
