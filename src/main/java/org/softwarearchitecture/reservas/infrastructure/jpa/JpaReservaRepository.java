package org.softwarearchitecture.reservas.infrastructure.jpa;

import org.softwarearchitecture.reservas.domain.model.Espacio;
import org.softwarearchitecture.reservas.domain.model.Reserva;
import org.softwarearchitecture.reservas.domain.model.Usuario;
import org.softwarearchitecture.reservas.domain.repository.ReservaRepository;
import org.softwarearchitecture.reservas.infrastructure.entity.EspacioEntity;
import org.softwarearchitecture.reservas.infrastructure.entity.ReservaEntity;
import org.softwarearchitecture.reservas.infrastructure.entity.UsuarioEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public abstract class JpaReservaRepository implements ReservaRepository {

    private final SpringDataReservaRepository springDataReservaRepository;

    public JpaReservaRepository(SpringDataReservaRepository springDataReservaRepository) {
        this.springDataReservaRepository = springDataReservaRepository;
    }

    @Override
    public Reserva guardar (Reserva reserva) {
        ReservaEntity entity = toEntity(reserva);
        ReservaEntity savedEntity = springDataReservaRepository.save(entity);
        return toDomain(savedEntity);
    }

    @Override
    public Optional<Reserva> buscarPorId(Long id) {
        return springDataReservaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Reserva> buscarPorFecha(Long espacioId, LocalDateTime fechaHora) {
        return springDataReservaRepository.buscarEspacioPorFecha(espacioId, fechaHora)
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    private ReservaEntity toEntity(Reserva reserva) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(reserva.getUsuario().getId());

        EspacioEntity espacioEntity = new EspacioEntity();
        espacioEntity.setId(reserva.getEspacio().getId());

        ReservaEntity reservaEntity = new ReservaEntity();
        reservaEntity.setId(reserva.getId());
        reservaEntity.setUsuario(usuarioEntity);
        reservaEntity.setEspacio(espacioEntity);
        reservaEntity.setFecha_hora(reserva.getFecha_hora());
        reservaEntity.setEstado(reserva.isEstado());

        return reservaEntity;
    }

    private Reserva toDomain(ReservaEntity reservaEntity) {
        Usuario usuario = new Usuario(reservaEntity.getUsuario().getId(), reservaEntity.getUsuario().getNombre(), reservaEntity.getUsuario().getEmail());
        Espacio espacio = new Espacio(reservaEntity.getEspacio().getId(), reservaEntity.getEspacio().getNombre());
        return new Reserva(reservaEntity.getId(), usuario, espacio, reservaEntity.getFecha_hora(), reservaEntity.isEstado());
    }
}
