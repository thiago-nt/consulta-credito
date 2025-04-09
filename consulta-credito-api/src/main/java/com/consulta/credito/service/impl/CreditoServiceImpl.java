package com.consulta.credito.service.impl;

import com.consulta.credito.dto.Credito;
import com.consulta.credito.entity.CreditoEntity;
import com.consulta.credito.repository.CreditoRepository;
import com.consulta.credito.service.CreditoService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CreditoServiceImpl implements CreditoService {

    private final CreditoRepository creditoRepository;

    public CreditoServiceImpl(CreditoRepository creditoRepository) {
        this.creditoRepository = creditoRepository;
    }

    @Override
    public List<Credito> consultarCreditoPorNumeroNfse(String numeroNfse) {
        List<CreditoEntity> entidades = creditoRepository.findByNumeroNfse(numeroNfse);
        return entidades.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Credito> consultarDetalhesCreditoPorNumeroCredito(String numeroCredito) {
        return creditoRepository.findByNumeroCredito(numeroCredito)
                .map(this::toDto);
    }

    private Credito toDto(CreditoEntity entity) {
        Credito dto = new Credito();
        dto.setNumeroCredito(entity.getNumeroCredito());
        dto.setNumeroNfse(entity.getNumeroNfse());
        dto.setValorFaturado(entity.getValorFaturado());
        dto.setAliquota(entity.getAliquota());
        dto.setDataConstituicao(entity.getDataConstituicao());
        dto.setTipoCredito(entity.getTipoCredito());
        dto.setValorDeducao(entity.getValorDeducao());
        dto.setValorIssqn(entity.getValorIssqn());
        dto.setBaseCalculo(entity.getBaseCalculo());
        return dto;
    }
}
