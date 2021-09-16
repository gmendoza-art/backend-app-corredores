package com.desarrollo.backendTesis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.desarrollo.backendTesis.entity.Social;

@Repository
public interface SocialRepository extends JpaRepository<Social, Integer>{

	@Query("SELECT soc \r\n"
	+ "FROM Usuarios usu, Social soc\r\n"
	+ "WHERE usu.idUsuario = soc.usuariosIdUsuarios order by soc.fechaCreacion desc")
	List<Social> listarPublicaciones();


}
