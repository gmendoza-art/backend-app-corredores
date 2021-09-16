package com.desarrollo.backendTesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrollo.backendTesis.entity.Usuarios;
import com.desarrollo.backendTesis.repository.UsuariosRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuariosRepository Urepo;
	
	public Usuarios saveUser (Usuarios user) {
		return Urepo.save(user);		
	}
	
	public Usuarios fetchUserByCorreo(String correo) {
		return Urepo.findByCorreo(correo);
	}
	
	public Usuarios fetchUserByCorreoAndContrasenia(String correo, String contrasenia) {
		return Urepo.findByCorreoAndContrasenia(correo, contrasenia);
	}

}
