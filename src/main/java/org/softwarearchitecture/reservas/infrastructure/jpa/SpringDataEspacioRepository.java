package org.softwarearchitecture.reservas.infrastructure.jpa;

import org.softwarearchitecture.reservas.infrastructure.entity.EspacioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataEspacioRepository extends JpaRepository<EspacioEntity, Long> {

}
