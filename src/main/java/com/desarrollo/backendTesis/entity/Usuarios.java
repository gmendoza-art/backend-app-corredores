package com.desarrollo.backendTesis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")

public class Usuarios{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int idUsuario;
	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "contrasenia")
	private String contrasenia;

	@Column(name = "correo")
	private String correo;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "permisos_id_permiso")
	private int permisos_id_permiso;

	public int getId_usuario() {
		return idUsuario;
	}

	public void setId_usuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getPermisos_id_permiso() {
		return permisos_id_permiso;
	}

	public void setPermisos_id_permiso(int permisos_id_permiso) {
		this.permisos_id_permiso = permisos_id_permiso;
	}

	
}

