package org.softwarearchitecture.reservas.application.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.softwarearchitecture.reservas.domain.model.Espacio;
import org.softwarearchitecture.reservas.domain.model.Reserva;
import org.softwarearchitecture.reservas.domain.model.Usuario;
import org.softwarearchitecture.reservas.domain.repository.ReservaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CancelarReservaUseCaseTest {
    private CancelarReservaUseCase cancelarReservaUseCase;
    private ReservaRepository reservaRepository;

    @BeforeEach
    public void setReservaRepository() {
        reservaRepository = mock(ReservaRepository.class);
        cancelarReservaUseCase = new CancelarReservaUseCase(reservaRepository);
    }

    @Test
    public void cancelarReserva() {
        Reserva reserva = new Reserva(1L,
                new Usuario(1L, "Sergio", "sergio.lema.e@ucb.edu.bo"),
                new Espacio(1L, "Salon 1"),
                LocalDateTime.now().plusDays(1),
                true);
        when(reservaRepository.buscarPorId(reserva.getId())).thenReturn(Optional.of(reserva));
        cancelarReservaUseCase.ejecutarCancelarReserva(reserva.getId());

        assertFalse(reserva.isEstado());
        verify(reservaRepository).guardar(reserva);
    }

    @Test
    public void cancelarReservaFallidaPorReservaNoEncontrada() {
        when(reservaRepository.buscarPorId(100L)).thenReturn(Optional.empty());
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> cancelarReservaUseCase.ejecutarCancelarReserva(100L));
        assertEquals("Reserva no encontrada", exception.getMessage());
    }
}
