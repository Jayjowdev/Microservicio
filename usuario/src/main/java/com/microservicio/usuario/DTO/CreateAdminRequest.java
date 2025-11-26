package com.microservicio.usuario.DTO;

public record CreateAdminRequest(
    String nombre,
    String correo,
    String usuario,
    String password,
    String contrasena
) {}
