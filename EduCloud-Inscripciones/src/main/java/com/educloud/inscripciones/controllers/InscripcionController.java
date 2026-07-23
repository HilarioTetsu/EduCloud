package com.educloud.inscripciones.controllers;

import com.educloud.inscripciones.model.dto.ActualizarEstadoDto;
import com.educloud.inscripciones.model.dto.InscripcionResponseDto;
import com.educloud.inscripciones.model.dto.RegistrarInscripcionDto;
import com.educloud.inscripciones.model.enums.EstadoInscripcion;
import com.educloud.inscripciones.services.I_InscripcionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/inscripcion")
@AllArgsConstructor
class InscripcionController {

    private final I_InscripcionService inscripcionService;


    @GetMapping("/{inscripcionId}")
    public ResponseEntity<InscripcionResponseDto> findById(@PathVariable UUID inscripcionId){

        return ResponseEntity.ok(inscripcionService.findById(inscripcionId));
    }

    @PostMapping
    public ResponseEntity<InscripcionResponseDto> registrarInscripcion(@RequestBody @Valid RegistrarInscripcionDto dto){

        return ResponseEntity.ok(inscripcionService.registrarInscripcion(dto));
    }

    @PatchMapping("/{inscripcionId}")
    public ResponseEntity<InscripcionResponseDto> actualizarEstado(@PathVariable UUID inscripcionId, @RequestBody ActualizarEstadoDto estado){

        return ResponseEntity.ok(inscripcionService.actualizarEstado(inscripcionId, estado));
    }


}
