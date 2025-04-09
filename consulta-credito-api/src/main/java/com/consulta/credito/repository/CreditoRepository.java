package com.consulta.credito.repository;

import com.consulta.credito.entity.CreditoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CreditoRepository extends JpaRepository<CreditoEntity, Long> {

    List<CreditoEntity> findByNumeroNfse(String numeroNfse);

    Optional<CreditoEntity> findByNumeroCredito(String numeroCredito);
}
