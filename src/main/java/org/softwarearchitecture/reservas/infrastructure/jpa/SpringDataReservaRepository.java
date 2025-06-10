package org.softwarearchitecture.reservas.infrastructure.jpa;

import org.softwarearchitecture.reservas.infrastructure.entity.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SpringDataReservaRepository extends JpaRepository<ReservaEntity, Long> {
    List<ReservaEntity> buscarEspacioPorFecha(Long id, LocalDateTime fecha);
}
