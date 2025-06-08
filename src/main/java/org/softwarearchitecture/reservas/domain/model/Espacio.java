package org.softwarearchitecture.reservas.domain.model;

public class Espacio {
    private Long id;
    private String nombre;

    public Espacio(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
}
