package com.vetnova.fichaclinicaservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetnova.fichaclinicaservice.model.FichaClinica;
import com.vetnova.fichaclinicaservice.repository.FichaClinicaRepository;

@Service
public class FichaClinicaService {

    @Autowired
    private FichaClinicaRepository fichaClinicaRepository;

    public List<FichaClinica> obtenerFichasClinicas() {
        return fichaClinicaRepository.findAll();
    }

    public FichaClinica obtenerFichaClinicaPorId(Long id) {
        return fichaClinicaRepository.findById(id).orElse(null);
    }

    public FichaClinica guardarFichaClinica(FichaClinica fichaClinica) {
        return fichaClinicaRepository.save(fichaClinica);
    }

    public FichaClinica actualizarFichaClinica(Long id, FichaClinica fichaActualizada) {
        Optional<FichaClinica> fichaExistente = fichaClinicaRepository.findById(id);

        if (fichaExistente.isPresent()) {
            FichaClinica ficha = fichaExistente.get();

            ficha.setMascotaId(fichaActualizada.getMascotaId());
            ficha.setVeterinarioId(fichaActualizada.getVeterinarioId());
            ficha.setAtencionId(fichaActualizada.getAtencionId());
            ficha.setMotivoConsulta(fichaActualizada.getMotivoConsulta());
            ficha.setDiagnostico(fichaActualizada.getDiagnostico());
            ficha.setTratamiento(fichaActualizada.getTratamiento());
            ficha.setReceta(fichaActualizada.getReceta());
            ficha.setObservaciones(fichaActualizada.getObservaciones());
            ficha.setFechaRegistro(fichaActualizada.getFechaRegistro());

            return fichaClinicaRepository.save(ficha);
        }

        return null;
    }

    public boolean eliminarFichaClinica(Long id) {
        if (fichaClinicaRepository.existsById(id)) {
            fichaClinicaRepository.deleteById(id);
            return true;
        }

        return false;
    }
}