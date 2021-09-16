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
import com.desarrollo.backendTesis.entity.Grupos;
import com.desarrollo.backendTesis.repository.GruposRepository;
import com.desarrollo.backendTesis.service.GruposService;

@RestController
@RequestMapping("grupos")
@CrossOrigin("*")
public class GruposRestController {

	@Autowired
	private GruposService service;

	@Autowired
    private GruposRepository gruRepo;

	   @GetMapping("/listar")
	    public List<Grupos> getGrupos() {
	        return gruRepo.findAll();
	    }
	    
		@PostMapping("/crear_grupo")
		public Grupos crearGrupo(@RequestBody Grupos gru)throws Exception{
			String nombre = gru.getNombre();
			if(nombre != null && !"".equals(nombre)) {
				Grupos gruObj = service.fetchGroupByName(nombre);
				if(gruObj != null) {
					throw new Exception("Group  "+nombre+" is already exist");
					
				}
			}
			Grupos gObj = null;
			gObj = service.saveGrupo(gru);
			return gObj;
		}
	
		
    @GetMapping(value="/{id}")
    public List<Grupos> getNameGroupById(@PathVariable int id)
         {
    	return gruRepo.buscarNombreGrupos(id);
         }
    
    @GetMapping(value="listarGrupoPorId/{id}")
    public Grupos getGroupById(@PathVariable int id)
         {
    	return gruRepo.listGroupsById(id);
         }
    
    @PutMapping("/{id}")
    public ResponseEntity<Grupos> updateGrupo(@PathVariable(value = "id") int id,
         @Validated @RequestBody Grupos gruDetalles) throws ResourceNotFoundException {
    	Grupos gru = gruRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Grupo No Encontrado"));

    	gru.setEstatus(gruDetalles.getEstatus());
        final Grupos updateGrupo = gruRepo.save(gru);
        return ResponseEntity.ok(updateGrupo);
    }
	
}
