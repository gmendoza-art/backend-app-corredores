package com.desarrollo.backendTesis.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.desarrollo.backendTesis.entity.UsuariosGrupos;
import com.desarrollo.backendTesis.repository.UsuariosGruposRepository;
import com.desarrollo.backendTesis.service.UsuariosGruposService;

@RestController
@RequestMapping("usuariosgrupos")
@CrossOrigin("*")
public class UsuariosGruposRestController {
	
	@Autowired
	private UsuariosGruposService service;

	@Autowired
    private UsuariosGruposRepository ugRepo;

	   @GetMapping("/listar")
	    public List<UsuariosGrupos> getUsuariosGrupos() {
	        return ugRepo.findAll();
	    }
	   
	    @GetMapping("/listar/{id}")
	    public List<UsuariosGrupos> getGruposById(@PathVariable(value = "id") int id)
	        {
	        return service.fetchUserGroupbyId(id);
	    }
	    
	    
		@PostMapping("/crear_usuario_grupo")
		public UsuariosGrupos crearUsuarioGrupo(@RequestBody UsuariosGrupos usugru)throws Exception{
			UsuariosGrupos UsuariosGruposObj = null;
			UsuariosGruposObj = service.saveUsuarioGrupo(usugru);
			return UsuariosGruposObj;
		}
		
	    @GetMapping("/usuarios_activos/{idGrupo}/{localizacion}")
	    public List<UsuariosGrupos> getGruposByIdIdGroupLocalitation
	    (@PathVariable(value = "idGrupo") int idGrupo, @PathVariable(value = "localizacion") int localizacion)
	        {
	        return service.fetchlocalizacion(idGrupo,localizacion);
	    }
		
		
	    @GetMapping("/buscar_usuarios_grupos/{idUsuario}/{idGrupo}")
	    public UsuariosGrupos getGruposByIdUsuarioandIdGroup
	    (@PathVariable(value = "idUsuario") int idUsuario, @PathVariable(value = "idGrupo") int idGrupo)
	        {
	        return ugRepo.findByidUsuarioandidGrupo(idUsuario,idGrupo);
	    }
		
	    
	    @PutMapping("localizacion_activa/{idUsuario}/{idGrupo}")
	    public ResponseEntity<UsuariosGrupos> updateUsuarioGrupoLocalizacion
	    (@PathVariable(value = "idUsuario") int idUsuario, @PathVariable(value = "idGrupo") int idGrupo,
	         @Validated @RequestBody UsuariosGrupos usuDetalles) throws ResourceNotFoundException {
	    	UsuariosGrupos usrgru = ugRepo.findByidUsuarioandidGrupo(idUsuario,idGrupo);
	
	    	usrgru.setLocalizacion(usuDetalles.getLocalizacion());
	    	usrgru.setLatitud(usuDetalles.getLatitud());
	    	usrgru.setLongitud(usuDetalles.getLongitud());

	        final UsuariosGrupos updateUsuarioGrupo = ugRepo.save(usrgru);
	        return ResponseEntity.ok(updateUsuarioGrupo);
	    }
		
}
