package com.insoftar.form.entities.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insoftar.form.Repository.UsuarioRepository;
import com.insoftar.form.entities.Usuario;
import com.insoftar.form.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario create(Usuario u) {
		// TODO Auto-generated method stub
		return this.usuarioRepository.save(u);
	}

	@Override
	public Usuario update(Usuario u) {
		// TODO Auto-generated method stub
		return this.usuarioRepository.save(u);
	}

	@Override
	public Iterable<Usuario> findAll() {
		// TODO Auto-generated method stub
		return this.usuarioRepository.findAll();
	}

	@Override
	public Usuario findByEmail(String email) {
		// TODO Auto-generated method stub
		return this.usuarioRepository.findByEmail(email);
	}

	@Override
	public Usuario findByCedula(Long cedula) {
		// TODO Auto-generated method stub
		return this.usuarioRepository.findByCedula(cedula);
	}
	
	


}
