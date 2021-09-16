package com.desarrollo.backendTesis.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.desarrollo.backendTesis.entity.Comentarios;

@Repository
public interface ComentariosRepository extends JpaRepository<Comentarios, Integer>{

	@Query("SELECT com \r\n"
	+ "FROM Comentarios com\r\n"
	+ "WHERE com.idGrupo = ?1 order by com.fecha desc")
	List<Comentarios> listarComentarios(int id);

}
