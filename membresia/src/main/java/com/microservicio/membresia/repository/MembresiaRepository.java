package com.microservicio.membresia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicio.membresia.model.Membresia;

public interface MembresiaRepository extends JpaRepository<Membresia, Long> {

}
