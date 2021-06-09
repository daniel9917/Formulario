package com.insoftar.form.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insoftar.form.entities.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	@Query(value = "SELECT * FROM usuario WHERE email = ?1", nativeQuery = true)
	public Usuario findByEmail(String email);
	
	@Query(value = "SELECT * FROM usuario WHERE cedula = ?1", nativeQuery = true)
	public Usuario findByCedula(Long cedula);
	
}
