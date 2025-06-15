package org.softwarearchitecture.reservas.application.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.softwarearchitecture.reservas.domain.model.*;
import org.softwarearchitecture.reservas.domain.repository.*;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CrearReservaUseCaseTest {
        private CrearReservaUseCase useCase;
        private ReservaRepository reservaRepository;
        private UsuarioRepository usuarioRepository;
        private EspacioRepository espacioRepository;

        @BeforeEach
        public void setUp() {
                reservaRepository = mock(ReservaRepository.class);
                usuarioRepository = mock(UsuarioRepository.class);
                espacioRepository = mock(EspacioRepository.class);

                useCase = new CrearReservaUseCase( reservaRepository, usuarioRepository, espacioRepository);
        }
        @Test
        public void crearReservaExitosa(){
                Long usuarioId = 1L;
                Long espacioId = 1L;
                LocalDateTime fecha = LocalDateTime.of(2025, 6, 15, 10, 0);

                Usuario usuario = new Usuario (usuarioId, "Sergio", "sergio.lema.e@ucb.edu.bo");
                Espacio espacio = new Espacio (espacioId, "Salon 1");

                when(usuarioRepository.buscarPorId(usuarioId)).thenReturn(Optional.of(usuario));
                when(espacioRepository.buscarPorId(espacioId)).thenReturn(Optional.of(espacio));

                Reserva reservaMock = new Reserva (1L, usuario, espacio, fecha, true);
                when(reservaRepository.guardar(any())).thenReturn(reservaMock);

                Reserva reserva = useCase.ejecutarReserva(usuarioId, espacioId, fecha);

                assertNotNull(reserva);
                assertEquals(usuarioId, reserva.getUsuario().getId());
                assertEquals(espacioId, reserva.getEspacio().getId());
                assertTrue(reserva.isEstado());
        }

        @Test
        public void crearReservaFallidaPorUsuarioNoEncontrado(){
                when(usuarioRepository.buscarPorId(100L)).thenReturn(Optional.empty());

                Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        useCase.ejecutarReserva(100L, 1L, LocalDateTime.now());
                });
                assertEquals("Usuario no encontrado", exception.getMessage());
        }
}