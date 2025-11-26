package com.contacto.contacto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contacto.contacto.model.Contacto;
import com.contacto.contacto.service.ContactoService;

@RestController
@RequestMapping("/contacto")
@CrossOrigin(origins = "http://localhost:5173") // para conectar con frontend React
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    @PostMapping("/guardar")
    public ResponseEntity<Contacto> guardarContacto(@RequestBody Contacto contacto) {
        try {
            Contacto contactoGuardado = contactoService.guardarContacto(contacto);
            return ResponseEntity.status(HttpStatus.CREATED).body(contactoGuardado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Contacto>> listarContactos() {
        List<Contacto> contactos = contactoService.listarContactos();
        return ResponseEntity.ok(contactos);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Contacto> buscarPorId(@PathVariable Long id) {
        Optional<Contacto> contacto = contactoService.buscarPorId(id);
        return contacto.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarContacto(@PathVariable Long id) {
        boolean eliminado = contactoService.eliminarContacto(id);
        if (eliminado) {
            return ResponseEntity.ok("Contacto eliminado exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Contacto no encontrado");
        }
    }
}
