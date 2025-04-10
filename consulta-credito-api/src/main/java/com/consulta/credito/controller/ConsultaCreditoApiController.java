package com.consulta.credito.controller;

import com.consulta.credito.dto.Credito;
import com.consulta.credito.messaging.EventoPublisher;
import com.consulta.credito.service.CreditoService;
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
    private final EventoPublisher publisher;

    public ConsultaCreditoApiController(CreditoService creditoService, EventoPublisher publisher) {
        this.creditoService = creditoService;
        this.publisher = publisher;
    }

    public ResponseEntity<List<Credito>> getConsultaCreditos(@PathVariable("numeroNfse") String numeroNfse) {
        publisher.publicarConsultaCredito(numeroNfse);
        List<Credito> creditos = creditoService.consultarCreditoPorNumeroNfse(numeroNfse);
        if (creditos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(creditos);
    }

    public ResponseEntity<Credito> getDetalhesCredito(@PathVariable("numeroCredito") String numeroCredito) {
        publisher.publicarConsultaCredito(numeroCredito);
        return creditoService.consultarDetalhesCreditoPorNumeroCredito(numeroCredito)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}