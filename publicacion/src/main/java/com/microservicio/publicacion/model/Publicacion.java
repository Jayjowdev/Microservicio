package com.microservicio.publicacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "publicaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Publicacion {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=100)
    private String titulo;

    @Column(nullable=false, length=100)
    private String empresa;

    @Column(nullable=false, length=100)
    private String ubicacion;

    @Column(nullable=false, length=100)
    private String salario;

    @Column(nullable=false, length=500)
    private String descripcion; 

    @Column(nullable=false, length=500)
    private String requisitos;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false, length=20)
    private TipoContrato tipoContrato;

    public enum TipoContrato {
        TIEMPO_COMPLETO,
        MEDIO_TIEMPO,
        FREELANCE,
        CONTRATO,
        PASANTIA
    }

}
