package com.desarrollo.backendTesis.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.backendTesis.entity.Permisos;
import com.desarrollo.backendTesis.repository.PermisosRepository;

@RestController
@RequestMapping("permisos")
@CrossOrigin("*")
public class PermisosRestController {

	@Autowired
    private PermisosRepository perRepo;

	
    @GetMapping("/listar")
    public List<Permisos> getPermisos() {
        return perRepo.findAll();
    }
}
