package com.desarrollo.backendTesis.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="social")
public class Social {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_social")
	private int idSocial;
	
	@Column(name = "texto")
	private String texto;

	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	@Column(name = "usuarios_id_usuario")
	private int usuariosIdUsuarios;
	
	@Column(name = "usuario_ingreso")
	private String usuariosIngreso;

	public int getIdSocial() {
		return idSocial;
	}

	public void setIdSocial(int idSocial) {
		this.idSocial = idSocial;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getUsuariosIdUsuarios() {
		return usuariosIdUsuarios;
	}

	public void setUsuariosIdUsuarios(int usuariosIdUsuarios) {
		this.usuariosIdUsuarios = usuariosIdUsuarios;
	}

	public String getUsuariosIngreso() {
		return usuariosIngreso;
	}

	public void setUsuariosIngreso(String usuariosIngreso) {
		this.usuariosIngreso = usuariosIngreso;
	}
	
}
