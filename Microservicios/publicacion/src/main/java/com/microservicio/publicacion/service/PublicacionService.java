package com.microservicio.publicacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicio.publicacion.model.Publicacion;
import com.microservicio.publicacion.repository.PublicacionRepository;

@Service
public class PublicacionService {

    @Autowired
    private PublicacionRepository publicacionRepository;

    // Método para guardar la publicación
    public Publicacion guardarPublicacion(Publicacion publicacion) {
        
        if (publicacion.getTitulo() == null || publicacion.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }
        if (publicacion.getEmpresa() == null || publicacion.getEmpresa().isEmpty()) {
            throw new IllegalArgumentException("La empresa no puede estar vacía");
        }
        if (publicacion.getUbicacion() == null || publicacion.getUbicacion().isEmpty()) {
            throw new IllegalArgumentException("La ubicación no puede estar vacía");
        }
        if (publicacion.getDescripcion() == null || publicacion.getDescripcion().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }
        if (publicacion.getTipoContrato() == null) {
            throw new IllegalArgumentException("El tipo de contrato no puede estar vacío");
        }
        return publicacionRepository.save(publicacion);
    }
}
