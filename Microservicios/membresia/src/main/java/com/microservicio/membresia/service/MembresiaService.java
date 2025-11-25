package com.microservicio.membresia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicio.membresia.model.Membresia;
import com.microservicio.membresia.repository.MembresiaRepository;

@Service
public class MembresiaService {

    @Autowired
    private MembresiaRepository membresiaRepository;

    // Método para guardar la membresía
    public Membresia guardarMembresia(Membresia membresia) {
        
        if (membresia.getTipoMembresia() == null || membresia.getTipoMembresia().isEmpty()) {
            throw new IllegalArgumentException("El tipo de membresía no puede estar vacío");
        }
        if (membresia.getTotal() == null || membresia.getTotal() <= 0) {
            throw new IllegalArgumentException("El total debe ser mayor a cero");
        }
        if (membresia.getFechaInicio() == null) {
            throw new IllegalArgumentException("La fecha de inicio no puede estar vacía");
        }
        if (membresia.getFechaFin() == null) {
            throw new IllegalArgumentException("La fecha de fin no puede estar vacía");
        }
        return membresiaRepository.save(membresia);
    }
}
