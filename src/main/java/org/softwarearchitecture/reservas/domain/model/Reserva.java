package org.softwarearchitecture.reservas.domain.model;

import java.time.LocalDateTime;

public class Reserva {
    private Long id;
    private Usuario usuario;
    private Espacio espacio;
    private LocalDateTime fechaHora;
    private boolean estado;

    public Reserva(Long id, Usuario usuario, Espacio espacio, LocalDateTime fechaHora, boolean estado) {
        this.id = id;
        this.usuario = usuario;
        this.espacio = espacio;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    public void cancelarReserva() {
        this.estado = false;
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
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    public boolean isEstado() {
        return estado;
    }
}
