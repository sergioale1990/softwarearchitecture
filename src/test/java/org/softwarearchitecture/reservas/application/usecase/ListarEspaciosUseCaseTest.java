package org.softwarearchitecture.reservas.application.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.softwarearchitecture.reservas.domain.model.Espacio;
import org.softwarearchitecture.reservas.domain.repository.EspacioRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ListarEspaciosUseCaseTest {

    private EspacioRepository espacioRepository;
    private ListarEspaciosUseCase listarEspaciosUseCase;

    @BeforeEach
    void setEspacioRepository() {
        espacioRepository = mock(EspacioRepository.class);
        listarEspaciosUseCase = new ListarEspaciosUseCase(espacioRepository);
    }

    @Test
    void listarEspacios() {
        List<Espacio> espacios = Arrays.asList(
                new Espacio(1L, "Salon 1"),
                new Espacio(2L, "Salon 2"),
                new Espacio(3L, "Salon 3")
        );

        when(espacioRepository.buscarTodos()).thenReturn(espacios);

        List<Espacio> espaciosListados = listarEspaciosUseCase.ejecutarListarEspacios();
        assertEquals(3, espaciosListados.size());
        verify(espacioRepository).buscarTodos();
    }
}
