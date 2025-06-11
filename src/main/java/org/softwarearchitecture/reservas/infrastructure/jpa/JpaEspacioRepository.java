package org.softwarearchitecture.reservas.infrastructure.jpa;

import org.softwarearchitecture.reservas.domain.model.Espacio;
import org.softwarearchitecture.reservas.domain.repository.EspacioRepository;
import org.softwarearchitecture.reservas.infrastructure.entity.EspacioEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaEspacioRepository implements EspacioRepository {

    private final SpringDataEspacioRepository springDataEspacioRepository;

    public JpaEspacioRepository(SpringDataEspacioRepository springDataEspacioRepository) {
        this.springDataEspacioRepository = springDataEspacioRepository;
    }

    @Override
    public Optional<Espacio> buscarPorId(Long espacioId) {
        return springDataEspacioRepository.findById(espacioId).map(this::toDomain);
    }

    @Override
    public List<Espacio> buscarTodos() {
        return springDataEspacioRepository.findAll()
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Espacio guardar(Espacio espacio) {
        EspacioEntity espacioEntity = new EspacioEntity();
        espacioEntity.setId(espacio.getId());
        espacioEntity.setNombre(espacio.getNombre());
        EspacioEntity savedEntity = springDataEspacioRepository.save(espacioEntity);
        return toDomain(savedEntity);
    }

    private Espacio toDomain(EspacioEntity espacioEntity) {
        return new Espacio(espacioEntity.getId(), espacioEntity.getNombre());
    }
}
