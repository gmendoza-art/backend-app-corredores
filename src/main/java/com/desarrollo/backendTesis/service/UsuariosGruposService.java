package com.desarrollo.backendTesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desarrollo.backendTesis.entity.UsuariosGrupos;
import com.desarrollo.backendTesis.repository.UsuariosGruposRepository;
import java.util.List;

@Service
public class UsuariosGruposService {

	@Autowired
	private UsuariosGruposRepository ugrepo;
	
	public UsuariosGrupos saveUsuarioGrupo (UsuariosGrupos ug) {
		return ugrepo.save(ug);		
	}
	
	public List<UsuariosGrupos> fetchUserGroupbyId(int id_usuario) {
		return ugrepo.findByidUsuario(id_usuario);
	}
	
	public List<UsuariosGrupos> fetchlocalizacion(int id_grupo, int localizacion) {
		return ugrepo.findByIdGrupoAndLocalizacion(id_grupo,localizacion);
	}
	
}
