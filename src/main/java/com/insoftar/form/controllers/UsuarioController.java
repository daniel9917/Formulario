package com.insoftar.form.controllers;

import java.awt.PageAttributes.MediaType;
import java.lang.annotation.Annotation;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.insoftar.form.entities.Usuario;
import com.insoftar.form.entities.servicesImpl.UsuarioServiceImpl;
import com.insoftar.form.response.HttpResponse;

@RestController
@RequestMapping(path = "/usuario")
@CrossOrigin
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;

	@GetMapping(path = "/hello")
	public @ResponseBody Object Hello() {

		return new String[] { "message", "Welcome from UsuarioController" };
	}

	@GetMapping("/all")
	public @ResponseBody Iterable<Usuario> getAll() {
		return this.usuarioServiceImpl.findAll();
	}

	@PostMapping("/create")
	public @ResponseBody Object create(@RequestBody Usuario u) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Usuario registrado;

		try {

			if (this.usuarioServiceImpl.findByEmail(u.getEmail()) == null) {
				if (this.usuarioServiceImpl.findByCedula(u.getCedula()) == null) {
					registrado = this.usuarioServiceImpl.create(u);
					return new HttpResponse(201, "Se ha creado el registro con exito", registrado);
				} else {
					return new HttpResponse(400, "Ya hay un usuario con la cedula ingresada.");
				}
			} else if (!(this.usuarioServiceImpl.findByEmail(u.getEmail()) == null)) {
				return new HttpResponse(400, "Ya hay un usuario con el correo ingresado.");
			} else {
				return new HttpResponse(400, "Revisar datos nuevamente.");
			}

		} catch (Exception E) {

			Set<ConstraintViolation<Usuario>> violations = validator.validate(u);
			Map<String, Object> errors = new HashMap<>();
			for (Iterator iterator = violations.iterator(); iterator.hasNext();) {
				ConstraintViolation<Usuario> constraintViolation = (ConstraintViolation<Usuario>) iterator.next();
				errors.put("name", constraintViolation.getMessage());
			}
			return new HttpResponse(400, "Formato de datos erróneo.", errors);

		}
	}


	@GetMapping("/cedula/{id}")
	public Object cedula(@PathVariable Long id) {
		Usuario resp = this.usuarioServiceImpl.findByCedula(id);

		return resp;

	}

	@GetMapping("/email/{email}")
	public Object email(@PathVariable String email) {
		Usuario resp = this.usuarioServiceImpl.findByEmail(email);

		return resp;
	}
	
	@PutMapping("/edit")
	public @ResponseBody Usuario update(@RequestBody Usuario user) {
		return this.usuarioServiceImpl.update(user);
	}
}
