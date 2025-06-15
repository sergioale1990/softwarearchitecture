package org.softwarearchitecture.reservas.application.usecase;

import org.softwarearchitecture.reservas.domain.model.Reserva;
import org.softwarearchitecture.reservas.domain.repository.ReservaRepository;

import java.util.Optional;

public class CancelarReservaUseCase {

    private final ReservaRepository reservaRepository;

    public CancelarReservaUseCase(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public void ejecutarCancelarReserva(Long idReserva) {
        Reserva reserva = reservaRepository.buscarPorId(idReserva)
                .orElseThrow(() -> new IllegalArgumentException("Reserva no encontrada"));
        if (!reserva.isEstado()) {
            throw new IllegalStateException("Reserva ya cancelada");
        }

        reserva.cancelarReserva();
        reservaRepository.guardar(reserva);
    }
}
