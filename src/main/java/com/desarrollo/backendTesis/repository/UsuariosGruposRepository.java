package com.desarrollo.backendTesis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desarrollo.backendTesis.entity.Grupos;
import com.desarrollo.backendTesis.entity.UsuariosGrupos;

import java.util.List;

@Repository
public interface UsuariosGruposRepository extends JpaRepository<UsuariosGrupos, Integer>{

	public List<UsuariosGrupos> findByidUsuario(int id_usuario);

	@Query("SELECT usrgru \r\n"
	+ "FROM UsuariosGrupos usrgru\r\n"
	+ "WHERE usrgru.idUsuario = ?1 and usrgru.idGrupo = ?2")
	UsuariosGrupos findByidUsuarioandidGrupo(int id_usuario, int id_grupo);
	
	public List<UsuariosGrupos> findByIdGrupoAndLocalizacion(int id_grupo, int localizacion);

}
