package com.vetnova.fichaclinicaservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vetnova.fichaclinicaservice.model.FichaClinica;
import com.vetnova.fichaclinicaservice.service.FichaClinicaService;

@RestController
@RequestMapping("/api/fichas-clinicas")
public class FichaClinicaController {

    @Autowired
    private FichaClinicaService fichaClinicaService;

    @GetMapping
    public List<FichaClinica> obtenerFichasClinicas() {
        return fichaClinicaService.obtenerFichasClinicas();
    }

    @GetMapping("/{id}")
    public FichaClinica obtenerFichaClinicaPorId(@PathVariable Long id) {
        return fichaClinicaService.obtenerFichaClinicaPorId(id);
    }

    @PostMapping
    public FichaClinica guardarFichaClinica(@RequestBody FichaClinica fichaClinica) {
        return fichaClinicaService.guardarFichaClinica(fichaClinica);
    }

    @PutMapping("/{id}")
    public FichaClinica actualizarFichaClinica(@PathVariable Long id,
                                               @RequestBody FichaClinica fichaClinica) {
        return fichaClinicaService.actualizarFichaClinica(id, fichaClinica);
    }

    @DeleteMapping("/{id}")
    public String eliminarFichaClinica(@PathVariable Long id) {
        boolean eliminada = fichaClinicaService.eliminarFichaClinica(id);

        if (eliminada) {
            return "Ficha clínica eliminada correctamente";
        }

        return "Ficha clínica no encontrada";
    }
}