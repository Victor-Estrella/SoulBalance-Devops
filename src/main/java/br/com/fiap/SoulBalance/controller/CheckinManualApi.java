package br.com.fiap.SoulBalance.controller;

import br.com.fiap.SoulBalance.dto.CheckinManualRequestDto;
import br.com.fiap.SoulBalance.dto.CheckinManualResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/checkin-manual")
@Tag(name = "Check-in Manual", description = "Operações de check-in manual do usuário")
public interface CheckinManualApi {

    @Operation(summary = "Registrar check-in manual", description = "Registra um novo check-in manual para o usuário.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Check-in registrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos para check-in")
    })
    @PostMapping
    ResponseEntity<CheckinManualResponseDto> saveChekin(@RequestBody CheckinManualRequestDto filter);

    @Operation(summary = "Listar histórico de check-ins", description = "Retorna o histórico de check-ins manuais de um usuário.")
    @ApiResponse(responseCode = "200", description = "Histórico retornado com sucesso")
    @GetMapping("/historico/{idUsuario}")
    ResponseEntity<List<CheckinManualResponseDto>> getAllByUsuario(@PathVariable Long idUsuario);
}
