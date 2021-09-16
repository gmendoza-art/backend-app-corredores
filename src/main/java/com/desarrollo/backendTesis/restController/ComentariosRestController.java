package com.desarrollo.backendTesis.restController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.desarrollo.backendTesis.entity.Comentarios;
import com.desarrollo.backendTesis.entity.Social;
import com.desarrollo.backendTesis.repository.ComentariosRepository;
import com.desarrollo.backendTesis.service.ComentarioService;

@RestController
@RequestMapping("comentarios")
@CrossOrigin("*")
public class ComentariosRestController {

	@Autowired
    private ComentarioService commentRepo;

	@Autowired
    private ComentariosRepository CRepo;
	
	@PostMapping("/crear_comentario")
	public Comentarios crearComentario(@RequestBody Comentarios comentario)throws Exception{
		Comentarios commentObj = null;
		commentObj = commentRepo.savecomment(comentario);
		return commentObj;
	}
	
	  @GetMapping("/{id}")
	  public List<Comentarios> getComentariosByIdGrupo(@PathVariable(value = "id") int id){
	      return CRepo.listarComentarios(id);
	  }
	  
	  @DeleteMapping("/{id}")
	  public Map<String, Boolean> deleteComentario(@PathVariable(value = "id") int id)
	     throws ResourceNotFoundException {
	    Comentarios comment = CRepo.findById(id)
	   .orElseThrow(() -> new ResourceNotFoundException("Comentario No Encontrado"));

	    CRepo.delete(comment);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return response;
	}

}
