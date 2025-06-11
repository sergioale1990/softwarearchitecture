package org.softwarearchitecture.reservas.web.controller;

import org.softwarearchitecture.reservas.application.usecase.CrearUsuarioUseCase;
import org.softwarearchitecture.reservas.domain.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final CrearUsuarioUseCase crearUsuarioUseCase;

    public UsuarioController(CrearUsuarioUseCase crearUsuarioUseCase) {
        this.crearUsuarioUseCase = crearUsuarioUseCase;
    }

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario newUsuario = crearUsuarioUseCase.ejecutarCrearUsuario(usuario.getNombre(), usuario.getEmail());
        return ResponseEntity.ok(newUsuario);
    }
}
