package org.softwarearchitecture.reservas.application.usecase;

import org.softwarearchitecture.reservas.domain.model.Reserva;
import org.softwarearchitecture.reservas.domain.repository.ReservaRepository;

import java.util.Optional;

public class CancelarReservaUseCase {

    private final ReservaRepository reservaRepository;

    public CancelarReservaUseCase(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public void ejecutarCancelarReserva(Long id) {
        Optional<Reserva> reserva = reservaRepository.buscarById(id);
        if (reserva.isPresent()) {
            reserva.get().cancelarReserva();
            reservaRepository.guardar(reserva.get());
        } else {
            throw new IllegalArgumentException("Reserva no encontrada");
        }
    }
}
