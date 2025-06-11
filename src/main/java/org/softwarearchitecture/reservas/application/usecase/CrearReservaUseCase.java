package org.softwarearchitecture.reservas.application.usecase;

import org.softwarearchitecture.reservas.domain.model.Espacio;
import org.softwarearchitecture.reservas.domain.model.Reserva;
import org.softwarearchitecture.reservas.domain.model.Usuario;
import org.softwarearchitecture.reservas.domain.repository.EspacioRepository;
import org.softwarearchitecture.reservas.domain.repository.ReservaRepository;
import org.softwarearchitecture.reservas.domain.repository.UsuarioRepository;

import java.time.LocalDateTime;

public class CrearReservaUseCase {

    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;
    private final EspacioRepository espacioRepository;

    public CrearReservaUseCase(ReservaRepository reservaRepository, UsuarioRepository usuarioRepository, EspacioRepository espacioRepository) {
        this.reservaRepository = reservaRepository;
        this.usuarioRepository = usuarioRepository;
        this.espacioRepository = espacioRepository;
    }

    public Reserva ejecutarReserva (Long idUsuario, Long idEspacio, LocalDateTime fechaHora) {
        Usuario usuario = usuarioRepository.buscarPorId(idUsuario).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado")) ;
        Espacio espacio = espacioRepository.buscarPorId(idEspacio).orElseThrow(() -> new IllegalArgumentException("Espacio no encontrado"));

        Reserva newReserva = new Reserva(null, usuario, espacio, fechaHora, true);
        return reservaRepository.guardar(newReserva);
    }

}
