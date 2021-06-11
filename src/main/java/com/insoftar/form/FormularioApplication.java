package com.insoftar.form;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@CrossOrigin
public class FormularioApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormularioApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				
				registry.addMapping("usuario/create")
				.allowedOrigins("http://localhost:8080","http://localhost:4200","http://localhost");
				registry.addMapping("usuario/edit")
				.allowedOrigins("http://localhost:8080","http://localhost:4200","http://localhost");
				registry.addMapping("usuario/all")
				.allowedOrigins("http://localhost:8080","http://localhost:4200","http://localhost");
				registry.addMapping("usuario/all/")
				.allowedOrigins("http://localhost:8080","http://localhost:4200","http://localhost");
				registry.addMapping("usuario/hello")
				.allowedOrigins("http://localhost:8080","http://localhost:4200","http://localhost");
				registry.addMapping("usuario/email/{email}")
				.allowedOrigins("http://localhost:8080","http://localhost:4200","http://localhost");
				registry.addMapping("usuario/cedula/{cedula}")
				.allowedOrigins("http://localhost:8080","http://localhost:4200","http://localhost");

			}
		};
	}

}
