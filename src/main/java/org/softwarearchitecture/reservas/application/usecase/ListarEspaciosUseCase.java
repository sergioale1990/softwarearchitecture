package org.softwarearchitecture.reservas.application.usecase;

import org.softwarearchitecture.reservas.domain.model.Espacio;
import org.softwarearchitecture.reservas.domain.repository.EspacioRepository;

import java.util.List;

public class ListarEspaciosUseCase {

    private final EspacioRepository espacioRepository;

    public ListarEspaciosUseCase(EspacioRepository espacioRepository) {
        this.espacioRepository = espacioRepository;
    }

    public List<Espacio> ejecutarListarEspacios () {
        return espacioRepository.buscarTodos();
    }
}
