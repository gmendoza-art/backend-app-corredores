package com.desarrollo.backendTesis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grupos")

public class Grupos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_grupo")
	private int idGrupo;
	
	@Column(name = "id_usuario_admin")
	private int id_usuario_admin;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "noticias")
	private String noticias;

	@Column(name = "estatus")
	private String estatus;
	
	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public int getId_usuario_admin() {
		return id_usuario_admin;
	}

	public void setId_usuario_admin(int id_usuario_admin) {
		this.id_usuario_admin = id_usuario_admin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNoticias() {
		return noticias;
	}

	public void setNoticias(String noticias) {
		this.noticias = noticias;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
}
