package com.microservicio.membresia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.membresia.model.Membresia;
import com.microservicio.membresia.service.MembresiaService;

@RestController
@RequestMapping("/membresia")
@CrossOrigin(origins = "http://localhost:5173") // para conectar con frontend React
public class MembresiaController {

    @Autowired
    private MembresiaService membresiaService;

    @PostMapping("/guardar")
    public Membresia guardarMembresia(@RequestBody Membresia membresia) {
        return membresiaService.guardarMembresia(membresia);
    }
}
