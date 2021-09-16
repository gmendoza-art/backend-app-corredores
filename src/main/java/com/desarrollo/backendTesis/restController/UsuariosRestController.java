package com.desarrollo.backendTesis.restController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
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
import com.desarrollo.backendTesis.repository.UsuariosRepository;
import com.desarrollo.backendTesis.service.UsuarioService;

import ch.qos.logback.classic.Logger;

import com.desarrollo.backendTesis.entity.Usuarios;


@RestController
@RequestMapping("usuario")
@CrossOrigin("*")
public class UsuariosRestController{
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
    private UsuariosRepository usrRepo;

    @GetMapping("buscar/{correo}")
    public ResponseEntity<Usuarios> getUsuarioByCorreo(@PathVariable(value = "correo") String correo)
        throws ResourceNotFoundException {
        Usuarios usr = usrRepo.findByCorreo(correo);
        return ResponseEntity.ok().body(usr);
    }
	
    @GetMapping("/listar")
    public List<Usuarios> getUsuarios() {
        return usrRepo.findAll();
    }
    
	@PostMapping("/registro")
	public Usuarios registerUser(@RequestBody Usuarios user)throws Exception{
		String correo = user.getCorreo();
		if(correo != null && !"".equals(correo)) {
			Usuarios userObj = service.fetchUserByCorreo(correo);
			if(userObj != null) {
				throw new Exception("User with "+correo+"is already exist");
				
			}
		}
		Usuarios userobj = null;
		userobj = service.saveUser(user);
		return userobj;
	}
	
	
    @PostMapping("/login")
    public Usuarios loginUser(@RequestBody Usuarios user)throws Exception {
    	String correo = user.getCorreo();
    	String contrasenia = user.getContrasenia();
    	Usuarios userObj = null;
    	if (correo != null && contrasenia != null) {
    		userObj = service.fetchUserByCorreoAndContrasenia(correo, contrasenia);
    	}
    	if (userObj == null) {
    		throw new Exception("Bad Credentials");
    	}
    	return userObj;
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> getUsuarioById(@PathVariable(value = "id") int id)
        throws ResourceNotFoundException {
        Usuarios usr = usrRepo.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        return ResponseEntity.ok().body(usr);
    }
    
//    
////    @GetMapping(value="/buscarlogin/{usr}/{contrasenia}")
////    public List<Usuarios> getUsuarioByUserandPsw(@PathVariable String usr, @PathVariable String contrasenia)
////         {
////    	return usrRepo.buscarDatosUsuario(usr, contrasenia);
////         }
// 	
//    
//    @PostMapping
//    public Usuarios createUsuario(@Validated @RequestBody Usuarios usr) {
//        return usrRepo.save(usr);
//    }
//    
//
    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> updateUsuario(@PathVariable(value = "id") int id,
         @Validated @RequestBody Usuarios usuDetalles) throws ResourceNotFoundException {
    	Usuarios usr = usrRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Usuario No Encontrado"));

    	usr.setNombre(usuDetalles.getNombre());
    	usr.setApellido(usuDetalles.getApellido());
    	usr.setCorreo(usuDetalles.getCorreo());
        usr.setTelefono(usuDetalles.getTelefono());
        usr.setDireccion(usuDetalles.getDireccion());
        usr.setPermisos_id_permiso(usuDetalles.getPermisos_id_permiso());
        final Usuarios updateUsuario = usrRepo.save(usr);
        return ResponseEntity.ok(updateUsuario);
    }


    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteUsuario(@PathVariable(value = "id") int id)
         throws ResourceNotFoundException {
        Usuarios user = usrRepo.findById(id)
       .orElseThrow(() -> new ResourceNotFoundException("Usuario No Encontrado"));

        usrRepo.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
//    
    
}

