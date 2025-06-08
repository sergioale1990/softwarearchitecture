package org.softwarearchitecture.reservas.domain.model;

import java.time.LocalDate;

public class Reserva {
    private Long id;
    private Usuario usuario;
    private Espacio espacio;
    private LocalDate fecha_hora;

    public Reserva(Long id, Usuario usuario, Espacio espacio, LocalDate fecha_hora) {
        this.id = id;
        this.usuario = usuario;
        this.espacio = espacio;
        this.fecha_hora = fecha_hora;
    }
    public Long getId() {
        return id;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public Espacio getEspacio() {
        return espacio;
    }
    public LocalDate getFecha_hora() {
        return fecha_hora;
    }
}
