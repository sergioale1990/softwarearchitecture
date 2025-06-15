package org.softwarearchitecture.reservas.web.controller;

import org.softwarearchitecture.reservas.application.usecase.CancelarReservaUseCase;
import org.softwarearchitecture.reservas.application.usecase.ConsultarDisponibilidadUseCase;
import org.softwarearchitecture.reservas.application.usecase.CrearReservaUseCase;
import org.softwarearchitecture.reservas.application.usecase.ListarReservasPorFechaUseCase;
import org.softwarearchitecture.reservas.domain.model.Reserva;
import org.softwarearchitecture.reservas.web.dto.CrearReservaDTO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final CrearReservaUseCase crearReservaUseCase;
    private final ConsultarDisponibilidadUseCase consultarDisponibilidadUseCase;
    private final CancelarReservaUseCase cancelarReservaUseCase;
    private final ListarReservasPorFechaUseCase listarReservasPorFechaUseCase;

    public ReservaController(CrearReservaUseCase crearReservaUseCase, ConsultarDisponibilidadUseCase consultarDisponibilidadUseCase, CancelarReservaUseCase cancelarReservaUseCase, ListarReservasPorFechaUseCase listarReservasPorFechaUseCase) {
        this.crearReservaUseCase = crearReservaUseCase;
        this.consultarDisponibilidadUseCase = consultarDisponibilidadUseCase;
        this.cancelarReservaUseCase = cancelarReservaUseCase;
        this.listarReservasPorFechaUseCase = listarReservasPorFechaUseCase;
    }
    @PostMapping
    public ResponseEntity<?> crearReserva (@RequestBody CrearReservaDTO crearReservaDTO) {
        try {
            Reserva reserva = crearReservaUseCase.ejecutarReserva(crearReservaDTO.idUsuario, crearReservaDTO.idEspacio, crearReservaDTO.fechaHora);
            return ResponseEntity.ok(reserva);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/disponibilidad")
    public ResponseEntity<?> consultarDisponibilidad (@RequestParam Long idEspacio, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaHora) {
        boolean disponible = consultarDisponibilidadUseCase.ejecutarConsultaDisponibilidad(idEspacio, fechaHora);
        return ResponseEntity.ok(disponible);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelarReserva (@PathVariable Long id) {
        try {
            cancelarReservaUseCase.ejecutarCancelarReserva(id);
            return ResponseEntity.ok("Reserva cancelada");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarReservas (@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaHora) {
        List<Reserva> reservas = listarReservasPorFechaUseCase.ejecutarListarReservasPorFecha(fechaHora);
        return ResponseEntity.ok(reservas);
    }
}
