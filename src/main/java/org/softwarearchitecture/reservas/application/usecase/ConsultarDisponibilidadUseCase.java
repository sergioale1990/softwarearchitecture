package org.softwarearchitecture.reservas.application.usecase;

import org.softwarearchitecture.reservas.domain.model.Reserva;
import org.softwarearchitecture.reservas.domain.repository.ReservaRepository;

import java.time.LocalDateTime;
import java.util.List;

public class ConsultarDisponibilidadUseCase {

    private final ReservaRepository reservaRepository;

    public ConsultarDisponibilidadUseCase(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public boolean ejecutarConsultaDisponibilidad(Long espacioId, LocalDateTime fechaHora) {
        return reservaRepository.buscarPorFecha(espacioId, fechaHora)
                .stream()
                .filter(Reserva::isEstado)
                .findAny()
                .isEmpty();
    }
}
