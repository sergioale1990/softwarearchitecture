package org.softwarearchitecture.reservas.infrastructure.config;

import org.softwarearchitecture.reservas.application.usecase.*;
import org.softwarearchitecture.reservas.domain.repository.EspacioRepository;
import org.softwarearchitecture.reservas.domain.repository.ReservaRepository;
import org.softwarearchitecture.reservas.domain.repository.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CrearReservaUseCase crearReservaUseCase (ReservaRepository reservaRepository,
                                                    UsuarioRepository usuarioRepository,
                                                    EspacioRepository espacioRepository) {
        return new CrearReservaUseCase(reservaRepository, usuarioRepository, espacioRepository);
    }

    @Bean
    public CrearUsuarioUseCase crearUsuarioUseCase (UsuarioRepository usuarioRepository) {
        return new CrearUsuarioUseCase(usuarioRepository);
    }

    @Bean
    public ListarEspaciosUseCase listarEspaciosUseCase (EspacioRepository espacioRepository) {
        return new ListarEspaciosUseCase(espacioRepository);
    }

    @Bean
    public ListarReservasPorFechaUseCase listarReservasPorFechaUseCase (ReservaRepository reservaRepository) {
        return new ListarReservasPorFechaUseCase(reservaRepository);
    }

    @Bean
    public CancelarReservaUseCase cancelarReservaUseCase (ReservaRepository reservaRepository) {
        return new CancelarReservaUseCase(reservaRepository);
    }
    @Bean
    public ConsultarDisponibilidadUseCase consultarDisponibilidadUseCase (ReservaRepository reservaRepository) {
        return new ConsultarDisponibilidadUseCase(reservaRepository);
    }

    @Bean
    public CrearEspacioUseCase crearEspacioUseCase (EspacioRepository espacioRepository) {
        return new CrearEspacioUseCase(espacioRepository);
    }
}
