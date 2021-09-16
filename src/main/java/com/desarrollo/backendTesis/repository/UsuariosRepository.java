package com.desarrollo.backendTesis.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desarrollo.backendTesis.entity.Usuarios;

@Repository
public interface UsuariosRepository  extends JpaRepository<Usuarios, Integer>{

	
//	@Query("SELECT usr \r\n"
//			+ "FROM Usuarios usr \r\n"
//			+ "WHERE usr.correo = ?1 and usr.contrasenia = ?2")
//	List<Usuarios> buscarDatosUsuario(String usuario, String contrasenia);

	public Usuarios findByCorreo(String correo);
	
	public Usuarios findByCorreoAndContrasenia(String correo, String contrasenia);
	
}
