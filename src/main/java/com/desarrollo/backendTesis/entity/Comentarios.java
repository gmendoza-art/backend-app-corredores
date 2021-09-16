package com.desarrollo.backendTesis.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comentarios")
public class Comentarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comentario")
	private int idComentario;
	
	@Column(name = "id_grupo")
	private int idGrupo;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "comentario")
	private String comentario;
	
	@Column(name = "id_usuario")
	private int idUsuario;

	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getidUsuario() {
		return idUsuario;
	}

	public void setidUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	

}
