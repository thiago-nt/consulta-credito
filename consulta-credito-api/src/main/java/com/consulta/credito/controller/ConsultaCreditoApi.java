package com.consulta.credito.controller;
import com.consulta.credito.dto.Credito;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Validated
public interface ConsultaCreditoApi {

    @RequestMapping(value = "/v1/creditos/{numeroNfse}",
        produces = { "application/json", "application/xml" },
        method = RequestMethod.GET)
    ResponseEntity<List<Credito>> getConsultaCreditos(@PathVariable("numeroNfse") String numeroNfse);

    @RequestMapping(value = "/v1/creditos/credito/{numeroCredito}",
        produces = { "application/json", "application/xml" },
        method = RequestMethod.GET)
    ResponseEntity<Credito> getDetalhesCredito(@PathVariable("numeroCredito") String numeroCredito);
}

