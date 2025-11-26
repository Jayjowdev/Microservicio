package com.contacto.contacto.repository;

import com.contacto.contacto.model.Contacto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends CrudRepository<Contacto, Long> {
}