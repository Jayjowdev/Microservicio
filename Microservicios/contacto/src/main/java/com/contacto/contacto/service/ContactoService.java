package com.contacto.contacto.service;

import com.contacto.contacto.model.Contacto;
import com.contacto.contacto.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;

    // Método para guardar el contacto
    public Contacto guardarContacto(Contacto contacto) {
        
        if (contacto.getNombre() == null || contacto.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        return contactoRepository.save(contacto);
    }
}
