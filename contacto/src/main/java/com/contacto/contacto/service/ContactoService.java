package com.contacto.contacto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contacto.contacto.model.Contacto;
import com.contacto.contacto.repository.ContactoRepository;

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

    // Método para listar todos los contactos
    public List<Contacto> listarContactos() {
        return (List<Contacto>) contactoRepository.findAll();
    }

    // Método para buscar contacto por ID
    public Optional<Contacto> buscarPorId(Long id) {
        return contactoRepository.findById(id);
    }

    // Método para eliminar contacto por ID
    public boolean eliminarContacto(Long id) {
        if (contactoRepository.existsById(id)) {
            contactoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
