package com.microservicio.publicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicio.publicacion.model.Publicacion;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {

}
