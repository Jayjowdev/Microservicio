package com.microservicio.usuario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicio.usuario.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
    
    Optional<Login> findByUsuario(String usuario);
    
    boolean existsByUsuario(String usuario);

}
