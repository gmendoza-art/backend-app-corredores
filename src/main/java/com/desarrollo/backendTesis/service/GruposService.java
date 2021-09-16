package com.desarrollo.backendTesis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desarrollo.backendTesis.entity.Grupos;
import com.desarrollo.backendTesis.repository.GruposRepository;

@Service
public class GruposService {

	@Autowired
	private GruposRepository gruRepo;
	
	public Grupos saveGrupo (Grupos grupo) {
		return gruRepo.save(grupo);		
	}
	
	public Grupos fetchGroupByName(String name) {
		return gruRepo.findByNombre(name);
	}
	
	
}
