package com.vetnova.fichaclinicaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetnova.fichaclinicaservice.model.FichaClinica;

public interface FichaClinicaRepository extends JpaRepository<FichaClinica, Long> {

}