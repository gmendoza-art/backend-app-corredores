package com.desarrollo.backendTesis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.desarrollo.backendTesis.entity.Permisos;

@Repository
public interface PermisosRepository extends JpaRepository<Permisos, Integer>{

}
