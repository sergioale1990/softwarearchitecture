package org.softwarearchitecture.reservas.application.usecase;

import org.softwarearchitecture.reservas.domain.model.Reserva;
import org.softwarearchitecture.reservas.domain.repository.ReservaRepository;

import java.time.LocalDateTime;
import java.util.List;

public class ListarReservasPorFechaUseCase {

    private final ReservaRepository reservaRepository;

    public ListarReservasPorFechaUseCase(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> ejecutarListarReservasPorFecha(LocalDateTime fecha) {
        List<Reserva> reservas = reservaRepository.buscarPorFecha(null, fecha);
        return reservas;
    }
}
