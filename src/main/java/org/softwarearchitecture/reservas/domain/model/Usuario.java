package org.softwarearchitecture.reservas.domain.model;

public class Usuario {
    private Long id;
    private String nombre;
    private String email;

    public Usuario(Long id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getEmail() {
        return email;
    }
}
