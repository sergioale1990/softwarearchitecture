package org.softwarearchitecture.reservas.infrastructure.jpa;

import org.softwarearchitecture.reservas.domain.model.Usuario;
import org.softwarearchitecture.reservas.domain.repository.UsuarioRepository;
import org.softwarearchitecture.reservas.infrastructure.entity.UsuarioEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public abstract class JpaUsuarioRepository implements UsuarioRepository {

    private final SpringDataUsuarioRepository springDataUsuarioRepository;

    public JpaUsuarioRepository(SpringDataUsuarioRepository springDataUsuarioRepository) {
        this.springDataUsuarioRepository = springDataUsuarioRepository;
    }

    @Override
    public Optional<Usuario> buscarPorId(Long usuarioId) {
        return springDataUsuarioRepository.findById(usuarioId).map(this::toDomain);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(usuario.getId());
        usuarioEntity.setNombre(usuario.getNombre());
        usuarioEntity.setEmail(usuarioEntity.getEmail());

        UsuarioEntity savedEntity = springDataUsuarioRepository.save(usuarioEntity);
        return toDomain(savedEntity);
    }

    private Usuario toDomain(UsuarioEntity usuarioEntity) {
        return new Usuario(usuarioEntity.getId(), usuarioEntity.getNombre(), usuarioEntity.getEmail());
    }
}
