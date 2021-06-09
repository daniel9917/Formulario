package com.insoftar.form.services;

import com.insoftar.form.entities.Usuario;

public interface UsuarioService {
	
	public Usuario create(Usuario u);
	public Usuario update(Usuario u);
	public Iterable<Usuario> findAll();
	public Usuario findByEmail(String email);
	public Usuario findByCedula(Long cedula);

}
