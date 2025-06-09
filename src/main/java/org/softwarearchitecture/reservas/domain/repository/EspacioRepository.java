package org.softwarearchitecture.reservas.domain.repository;

import org.softwarearchitecture.reservas.domain.model.Espacio;

import java.util.List;
import java.util.Optional;

public interface EspacioRepository {
    Optional<Espacio> buscarById(Long id);
    List<Espacio> buscarTodos();
}
