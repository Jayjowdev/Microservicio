package com.microservicio.publicacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.publicacion.model.Publicacion;
import com.microservicio.publicacion.service.PublicacionService;

@RestController
@RequestMapping("/publicacion")
@CrossOrigin(origins = "http://localhost:5173") // para conectar con frontend React
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

    @PostMapping("/guardar")
    public Publicacion guardarPublicacion(@RequestBody Publicacion publicacion) {
        return publicacionService.guardarPublicacion(publicacion);
    }
}
