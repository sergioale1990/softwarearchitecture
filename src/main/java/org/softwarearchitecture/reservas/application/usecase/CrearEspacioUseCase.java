package org.softwarearchitecture.reservas.application.usecase;

import org.softwarearchitecture.reservas.domain.model.Espacio;
import org.softwarearchitecture.reservas.domain.repository.EspacioRepository;

public class CrearEspacioUseCase {

    private final EspacioRepository espacioRepository;

    public CrearEspacioUseCase(EspacioRepository espacioRepository) {
        this.espacioRepository = espacioRepository;
    }

    public Espacio ejecutarCrearEspacio(String nombre) {
        return espacioRepository.guardar(new Espacio(null, nombre));
    }
}
