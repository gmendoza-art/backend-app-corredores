package com.desarrollo.backendTesis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="permisos")

public class Permisos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_permiso")
	private int idPermiso;
	
	@Column(name = "permiso")
	private String permiso;

	public int getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public String getPermiso() {
		return permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}


	

}
