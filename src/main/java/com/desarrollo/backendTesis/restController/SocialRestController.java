package com.desarrollo.backendTesis.restController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.desarrollo.backendTesis.entity.Social;
import com.desarrollo.backendTesis.repository.SocialRepository;
import com.desarrollo.backendTesis.service.SocialService;

@RestController
@RequestMapping("social")
@CrossOrigin("*")
public class SocialRestController {

	@Autowired
    private SocialService socialRepo;
	
	@Autowired
    private SocialRepository sRepo;

	@PostMapping("/crear_publicacion")
	public Social crearPublicacion(@RequestBody Social social)throws Exception{
		Social socialObj = null;
		socialObj = socialRepo.savepubli(social);
		return socialObj;
	}
	
    @GetMapping("/listar")
    public List<Social> getPublicaciones() {
        return sRepo.listarPublicaciones();
    }
    
  @GetMapping("/{id}")
  public ResponseEntity<Social> getPublicacionesById(@PathVariable(value = "id") int id)
      throws ResourceNotFoundException {
      Social soc = sRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Publicación no encontrado"));
      return ResponseEntity.ok().body(soc);
  }
    
  @PutMapping("/{id}")
  public ResponseEntity<Social> updatePublicacion(@PathVariable(value = "id") int id,
       @Validated @RequestBody Social socDetalles) throws ResourceNotFoundException {
  	Social soc = sRepo.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Publicacion No Encontrado"));
 	  soc.setTexto(socDetalles.getTexto());
      final Social updateSocial = sRepo.save(soc);
      return ResponseEntity.ok(updateSocial);
  }
  
  @DeleteMapping("/{id}")
  public Map<String, Boolean> deletePublicacion(@PathVariable(value = "id") int id)
     throws ResourceNotFoundException {
    Social soc = sRepo.findById(id)
   .orElseThrow(() -> new ResourceNotFoundException("Publicacion No Encontrado"));

    sRepo.delete(soc);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
}

}
