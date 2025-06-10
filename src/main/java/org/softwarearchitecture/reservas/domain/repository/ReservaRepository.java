package org.softwarearchitecture.reservas.domain.repository;

import org.softwarearchitecture.reservas.domain.model.Reserva;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservaRepository {
    Reserva guardar (Reserva reserva);
    Optional<Reserva> buscarPorId(Long id);
    List<Reserva> buscarPorFecha (Long espacioId, LocalDateTime fecha);
    Reserva cancelar (Long id);
}
