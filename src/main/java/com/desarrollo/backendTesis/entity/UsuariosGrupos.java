package com.desarrollo.backendTesis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios_grupos")

public class UsuariosGrupos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuarios_grupos")
	private int id_usuarios_grupos;
	
	@Column(name = "usuarios_id_usuario")
	private int idUsuario;

	@Column(name = "grupos_id_grupo")
	private int idGrupo;

	@Column(name = "localizacion")
	private int localizacion;
	
	@Column(name = "latitud")
	private double latitud;
	
	@Column(name = "longitud")
	private double longitud;
	
	public int getId_usuarios_grupos() {
		return id_usuarios_grupos;
	}

	public void setId_usuarios_grupos(int id_usuarios_grupos) {
		this.id_usuarios_grupos = id_usuarios_grupos;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public int getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(int localizacion) {
		this.localizacion = localizacion;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	
	
}
