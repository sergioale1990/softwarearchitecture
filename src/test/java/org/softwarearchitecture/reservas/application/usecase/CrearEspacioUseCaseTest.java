package org.softwarearchitecture.reservas.application.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.softwarearchitecture.reservas.domain.model.Espacio;
import org.softwarearchitecture.reservas.domain.repository.EspacioRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CrearEspacioUseCaseTest {

    private CrearEspacioUseCase crearEspacioUseCase;
    private EspacioRepository espacioRepository;

    @BeforeEach
    void setEspacioRepository() {
        espacioRepository = mock(EspacioRepository.class);
        crearEspacioUseCase = new CrearEspacioUseCase(espacioRepository);
    }

    @Test
    public void crearEspacio() {
        Espacio espacioEsperado = new Espacio(1L,"Salon 1");

        when(espacioRepository.guardar(any())).thenReturn(espacioEsperado);

        Espacio espacioCreado = crearEspacioUseCase.ejecutarCrearEspacio("Salon 1");

        assertEquals("Salon 1", espacioCreado.getNombre());
        verify(espacioRepository).guardar(any());
    }
}
