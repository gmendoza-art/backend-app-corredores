package com.desarrollo.backendTesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desarrollo.backendTesis.entity.Comentarios;
import com.desarrollo.backendTesis.repository.ComentariosRepository;

@Service
public class ComentarioService {

	@Autowired
	private ComentariosRepository Crepo;
	
	public Comentarios savecomment(Comentarios comentarios) {
		return Crepo.save(comentarios);		
	}
}
