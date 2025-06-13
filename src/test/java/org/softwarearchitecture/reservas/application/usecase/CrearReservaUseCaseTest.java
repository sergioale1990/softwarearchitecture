package org.softwarearchitecture.reservas.application.usecase;

import org.junit.jupiter.api.BeforEach;
import org.junit.jupiter.api.Test;
import org.softwarearchitecture.reservas.domain.model.*;
import org.softwarearchitecture.reservas.domain.repository.*;

public class CrearReservaUseCaseTest() {
        private CrearReservaUseCase useCase;
        private ReservaRepository reservaRepository;
        private UsuarioRepository usuarioRepository;
        private EspacioRepository espacioRepository;

        @BeforeEach
        public void setUp() {
                reservaRepository = mock(ReservaRepository.class);
                usuarioRepository = mock(UsuarioRepository.class);
                espacioRepository = mock(EspacioRepository.class);

                useCase = new CrearReservaUseCase( reservaRepository, usuarioRepository, espacioRepository;
        }
        @Test
        public void crearReserva_exitosa(){
                Long usuarioId = 1L;
                Long espacioId = 1L;
                LocalDateTime fecha = LocalDateTime.of(2025, 6, 15, 10, 0);

                Usuario usuario = new Usuario (usuarioId, "Sergio", "sergio.lema.e@ucb.edu.bo");
                Espacio espacio = new Espacio (espacioId, "Salon 1");

                when(usuarioRepository.buscarPorId(usuarioId).thenReturn(Optional.of(usuario)));
                when(espacioRepository.buscarPorId(espacioId).thenReturn(Optional.of(espacio)));

                Reserva reservaMock = new Reserva (1L, usuario, espacio, fecha, true);
                when(reservaRepository.guardar(any())).thenReturn(reservaMock);

                Reserva reserva = useCase.ejecutar(usuarioId, espacioId, fecha);

                assertNotNull(reserva);
                assertEquals(usuarioId, reserva.getUsuario().getId());
                assertEquals(espacioId, reserva.getEspacio().getId());
                assertTrue(reserva.isEstado());
        }
}