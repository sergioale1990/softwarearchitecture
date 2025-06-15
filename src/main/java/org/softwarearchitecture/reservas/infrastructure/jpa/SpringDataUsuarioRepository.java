package org.softwarearchitecture.reservas.infrastructure.jpa;

import org.softwarearchitecture.reservas.infrastructure.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
