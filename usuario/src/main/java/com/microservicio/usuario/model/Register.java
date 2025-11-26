package com.microservicio.usuario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Register {
   
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) 
    Long id;

    @Column(nullable=false, length=100)
    String nombre;

    @Column(nullable=false, length=100)
    String correo;

    @Column(nullable=false, length=100)
    String usuario;
    
    @Column(nullable=false, length=100)
    String contrasena;

    @Column(length=15)
    String telefono;
}
