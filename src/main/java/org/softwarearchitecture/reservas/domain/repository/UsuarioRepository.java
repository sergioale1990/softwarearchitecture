package org.softwarearchitecture.reservas.domain.repository;

import org.softwarearchitecture.reservas.domain.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> buscarPorId(Long id);
    Usuario guardar(Usuario usuario);
}
