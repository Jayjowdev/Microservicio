package com.microservicio.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.usuario.DTO.CreateAdminRequest;
import com.microservicio.usuario.DTO.RegisterRequest;
import com.microservicio.usuario.model.Register;
import com.microservicio.usuario.service.RegisterService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173") // para conectar con frontend React
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<?> registrarUsuario(@RequestBody RegisterRequest request) {
        try {
            Register register = new Register();
            register.setNombre(request.nombre());
            register.setCorreo(request.correo());
            register.setUsuario(request.usuario());
            register.setContrasena(request.contrasena());
            register.setTelefono(null); // Opcional

            Register resultado = registerService.registrarUsuario(register);
            return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/admin/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> crearAdmin(@RequestBody CreateAdminRequest request) {
        try {
            Register register = new Register();
            register.setNombre(request.nombre());
            register.setCorreo(request.correo());
            register.setUsuario(request.usuario());
            register.setContrasena(request.contrasena());

            Register resultado = registerService.crearAdmin(register);
            return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
