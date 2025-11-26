package com.microservicio.membresia.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "membresias")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Membresia {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String tipoMembresia;

    @Column(nullable=false)
    private Double Total;

    @Column(nullable=false)
    private Date fechaInicio;

    @Column(nullable=false)
    private Date fechaFin;
}