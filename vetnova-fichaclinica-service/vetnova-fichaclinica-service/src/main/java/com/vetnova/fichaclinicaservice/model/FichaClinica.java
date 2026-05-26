package com.vetnova.fichaclinicaservice.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fichas_clinicas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FichaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long mascotaId;
    private Long veterinarioId;
    private Long atencionId;

    private String motivoConsulta;
    private String diagnostico;
    private String tratamiento;
    private String receta;
    private String observaciones;

    private LocalDate fechaRegistro;
}