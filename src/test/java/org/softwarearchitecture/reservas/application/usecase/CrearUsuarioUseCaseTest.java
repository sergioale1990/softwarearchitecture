package org.softwarearchitecture.reservas.application.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.softwarearchitecture.reservas.domain.model.Usuario;
import org.softwarearchitecture.reservas.domain.repository.UsuarioRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CrearUsuarioUseCaseTest {

    private UsuarioRepository usuarioRepository;
    private CrearUsuarioUseCase crearUsuarioUseCase;

    @BeforeEach
    void setUsuarioRepository() {
        usuarioRepository = mock(UsuarioRepository.class);
        crearUsuarioUseCase = new CrearUsuarioUseCase(usuarioRepository);
    }

    @Test
    void registrarUsuarioSatisfactoriamente() {
        Usuario usuarioEsperado = new Usuario(1L,"Sergio", "sergio.lema.e@ucb.edu.bo");
        when(usuarioRepository.guardar(any())).thenReturn(usuarioEsperado);

        Usuario usuarioGuardado = crearUsuarioUseCase.ejecutarCrearUsuario("Sergio", "sergio.lema.e@ucb.edu.bo");
        assertNotNull(usuarioGuardado);
        assertEquals(usuarioEsperado.getNombre(), usuarioGuardado.getNombre());
        verify(usuarioRepository).guardar(any());
    }
}
