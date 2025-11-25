package com.contacto.contacto.controller;

import com.contacto.contacto.model.Contacto;
import com.contacto.contacto.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacto")
@CrossOrigin(origins = "http://localhost:5173") // para conectar con frontend React
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    @PostMapping("/guardar")
    public Contacto guardarContacto(@RequestBody Contacto contacto) {
        return contactoService.guardarContacto(contacto);
    }
}
