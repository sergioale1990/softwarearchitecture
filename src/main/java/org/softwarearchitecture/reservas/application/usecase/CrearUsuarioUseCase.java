package org.softwarearchitecture.reservas.application.usecase;

import org.softwarearchitecture.reservas.domain.model.Usuario;
import org.softwarearchitecture.reservas.domain.repository.UsuarioRepository;

public class CrearUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    public CrearUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario ejecutarCrearUsuario (String nombre, String email) {
        return usuarioRepository.guardar(new Usuario(null, nombre, email));
    }
}
