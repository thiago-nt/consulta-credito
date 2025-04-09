package com.consulta.credito.controller;

import com.consulta.credito.dto.Credito;
import com.consulta.credito.dto.DetalhesCredito;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ConsultaCreditoApiController implements ConsultaCreditoApi {

    private static final Logger log = LoggerFactory.getLogger(ConsultaCreditoApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ConsultaCreditoApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Credito>> getConsultaCreditos(@Parameter(in = ParameterIn.PATH, description = "Consulta créditos por numeroNfse", required=true, schema=@Schema()) @PathVariable("numeroNfse") String numeroNfse
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Credito>>(objectMapper.readValue("[ {\n  \"numeroCredito\" : \"123456\",\n  \"numeroNfse\" : \"7891011\",\n  \"valorFaturado\" : 30000,\n  \"simplesNacional\" : \"Sim\",\n  \"aliquota\" : 5,\n  \"dataConstituicao\" : \"2024-02-25T00:00:00.000+00:00\",\n  \"tipoCredito\" : \"ISSQN\",\n  \"valorDeducao\" : 5000,\n  \"valorIssqn\" : 1500.75,\n  \"baseCalculo\" : 25000\n}, {\n  \"numeroCredito\" : \"123456\",\n  \"numeroNfse\" : \"7891011\",\n  \"valorFaturado\" : 30000,\n  \"simplesNacional\" : \"Sim\",\n  \"aliquota\" : 5,\n  \"dataConstituicao\" : \"2024-02-25T00:00:00.000+00:00\",\n  \"tipoCredito\" : \"ISSQN\",\n  \"valorDeducao\" : 5000,\n  \"valorIssqn\" : 1500.75,\n  \"baseCalculo\" : 25000\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Credito>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Credito>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<DetalhesCredito> getDetalhesCredito(@Parameter(in = ParameterIn.PATH, description = "Retorna os detalhes de um crédito constituído", required=true, schema=@Schema()) @PathVariable("numeroCredito") String numeroCredito
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<DetalhesCredito>(objectMapper.readValue("{\n  \"numeroCredito\" : \"123456\",\n  \"numeroNfse\" : \"7891011\",\n  \"valorFaturado\" : 30000,\n  \"simplesNacional\" : \"Sim\",\n  \"aliquota\" : 5,\n  \"dataConstituicao\" : \"2024-02-25T00:00:00.000+00:00\",\n  \"tipoCredito\" : \"ISSQN\",\n  \"valorDeducao\" : 5000,\n  \"valorIssqn\" : 1500.75,\n  \"baseCalculo\" : 25000\n}", DetalhesCredito.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<DetalhesCredito>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<DetalhesCredito>(HttpStatus.NOT_IMPLEMENTED);
    }

}
