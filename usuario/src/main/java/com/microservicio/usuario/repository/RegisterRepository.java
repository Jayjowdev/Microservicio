package com.microservicio.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicio.usuario.model.Register;

public interface RegisterRepository extends JpaRepository<Register, Long>{
    
    boolean existsByUsuario(String usuario);
    
    boolean existsByCorreo(String correo);

}
