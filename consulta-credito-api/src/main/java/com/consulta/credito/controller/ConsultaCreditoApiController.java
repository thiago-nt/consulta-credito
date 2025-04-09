package com.consulta.credito.controller;

import com.consulta.credito.dto.Credito;
import com.consulta.credito.service.CreditoService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ConsultaCreditoApiController implements ConsultaCreditoApi {

    private static final Logger log = LoggerFactory.getLogger(ConsultaCreditoApiController.class);

    private final CreditoService creditoService;

    public ConsultaCreditoApiController(CreditoService creditoService) {
        this.creditoService = creditoService;
    }

    public ResponseEntity<List<Credito>> getConsultaCreditos(
            @Parameter(in = ParameterIn.PATH, description = "Consulta créditos por numeroNfse", required = true,
                    schema = @Schema()) @PathVariable("numeroNfse") String numeroNfse) {

        List<Credito> creditos = creditoService.consultarCreditoPorNumeroNfse(numeroNfse);
        if (creditos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(creditos);
    }

    public ResponseEntity<Credito> getDetalhesCredito(
            @Parameter(in = ParameterIn.PATH, description = "Retorna os detalhes de um crédito constituído", required = true,
                    schema = @Schema()) @PathVariable("numeroCredito") String numeroCredito) {

        return creditoService.consultarDetalhesCreditoPorNumeroCredito(numeroCredito)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}