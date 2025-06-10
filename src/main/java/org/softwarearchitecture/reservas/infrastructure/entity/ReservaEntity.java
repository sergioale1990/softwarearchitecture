package org.softwarearchitecture.reservas.infrastructure.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @Getter
    @Setter
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "espacio_id")
    @Getter
    @Setter
    private EspacioEntity espacio;

    @Getter
    @Setter
    private boolean estado;

    @Getter
    @Setter
    private LocalDateTime fecha_hora;
}
