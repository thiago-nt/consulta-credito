package com.consulta.credito.service;

import com.consulta.credito.dto.Credito;

import java.util.List;
import java.util.Optional;

public interface CreditoService {

    List<Credito> consultarCreditoPorNumeroNfse(String numeroNfse);

    Optional<Credito> consultarDetalhesCreditoPorNumeroCredito(String numeroCredito);

}
