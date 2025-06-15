package org.softwarearchitecture.reservas.web.controller;


import org.softwarearchitecture.reservas.application.usecase.CrearEspacioUseCase;
import org.softwarearchitecture.reservas.application.usecase.ListarEspaciosUseCase;
import org.softwarearchitecture.reservas.domain.model.Espacio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/espacios")
public class EspacioController {

    private final CrearEspacioUseCase crearEspacioUseCase;
    private final ListarEspaciosUseCase listarEspaciosUseCase;

    public EspacioController(CrearEspacioUseCase crearEspacioUseCase, ListarEspaciosUseCase listarEspaciosUseCase) {
        this.listarEspaciosUseCase = listarEspaciosUseCase;
        this.crearEspacioUseCase = crearEspacioUseCase;
    }

    @PostMapping
    public ResponseEntity<Espacio> crearEspacio (@RequestBody Espacio espacio ) {
        Espacio newEspacio = crearEspacioUseCase.ejecutarCrearEspacio(espacio.getNombre());
        return ResponseEntity.ok(newEspacio);
    }

    @GetMapping
    public List<Espacio> listarEspacios () {
        return listarEspaciosUseCase.ejecutarListarEspacios();
    }

}
