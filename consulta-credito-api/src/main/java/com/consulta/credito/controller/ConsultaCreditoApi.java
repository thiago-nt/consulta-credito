package com.consulta.credito.controller;
import com.consulta.credito.dto.Credito;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Validated
public interface ConsultaCreditoApi {

    @Operation(summary = "Consulta créditos por numero da Nfse.", description = "Retorna uma lista de créditos.", tags={ "consultaCredito" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        @ApiResponse(responseCode = "500", description = "Unexpected error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class)))})
    @RequestMapping(value = "/api/creditos/{numeroNfse}",
        produces = { "application/json", "application/xml" },
        method = RequestMethod.GET)
    ResponseEntity<List<Credito>> getConsultaCreditos(@Parameter(in = ParameterIn.PATH, description = "Consulta créditos por numeroNfse", required=true, schema=@Schema()) @PathVariable("numeroNfse") String numeroNfse
);


    @Operation(summary = "Consulta detalhes de um créditos por numero do credito.", description = "Retorna os detalhes de um crédito constituído.", tags={ "consultaCredito" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        @ApiResponse(responseCode = "500", description = "Erro interno inesperado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class)))})
    @RequestMapping(value = "/api/creditos/credito/{numeroCredito}",
        produces = { "application/json", "application/xml" },
        method = RequestMethod.GET)
    ResponseEntity<Credito> getDetalhesCredito(@Parameter(in = ParameterIn.PATH, description = "Retorna os detalhes de um crédito constituído", required=true, schema=@Schema()) @PathVariable("numeroCredito") String numeroCredito
);

}

