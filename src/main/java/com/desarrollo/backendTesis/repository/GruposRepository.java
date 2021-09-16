package com.desarrollo.backendTesis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.desarrollo.backendTesis.entity.Grupos;

@Repository
public interface GruposRepository extends JpaRepository<Grupos, Integer>{
	
	public Grupos findByNombre(String nombre);

	@Query("SELECT gru \r\n"
	+ "FROM Grupos gru, UsuariosGrupos usrgru\r\n"
	+ "WHERE gru.idGrupo = usrgru.idGrupo and usrgru.idUsuario = ?1")
List<Grupos> buscarNombreGrupos(int id);

	
	@Query("SELECT gru \r\n"
	+ "FROM Grupos gru\r\n"
	+ "WHERE gru.idGrupo = ?1")
	Grupos listGroupsById(int id);

}
