package com.insoftar.form.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

@Entity
public class Usuario implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Nombre: No debe estar vacío.")	
	@Pattern(regexp="^[A-Za-z]*$",message = "Nombre: Solo se aceptan letras")
	private String nombre;
		
	@NotBlank(message = "Apellido: No debe estar vacío.")
	@Pattern(regexp="^[A-Za-z]*$",message = "Apellido: Solo se aceptan letras")
	private String apellido;
	
	@Min(value = 1,
		message = "Cédula: Formato numérico de hasta 10 dígitos.")
	@Digits(fraction = 0,
			integer = 12,
			message = "Cédula: Formato numérico de hasta 12 dígitos.")	
	private Long cedula;
		
	@Email(message = "Email should be valid email format: xxxx@xxxxx.com/co/org...")	
	private String email;
	
	@Min(value = 1, 
		 message = "Teléfono: Formato numérico de hasta 10 dígitos.")
	@Digits(fraction = 0, 
			integer = 10, 
			message = "Teléfono: Formato numérico de hasta 10 dígitos.")	
	private Long telefono;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}		
	
	
	
	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getCedula() {
		return cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
