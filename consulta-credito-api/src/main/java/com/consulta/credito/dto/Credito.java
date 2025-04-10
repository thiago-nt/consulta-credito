package com.consulta.credito.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Credito {

  @NotNull
  private String numeroCredito;

  @NotNull
  private String numeroNfse;

  @NotNull
  @Valid
  private LocalDate dataConstituicao;

  @NotNull
  private BigDecimal valorIssqn;

  @NotNull
  private String tipoCredito;

  @NotNull
  private SimplesNacionalEnum simplesNacional;

  @NotNull
  private BigDecimal aliquota;

  @NotNull
  private BigDecimal valorFaturado;

  @NotNull
  private BigDecimal valorDeducao;

  @NotNull
  private BigDecimal baseCalculo;

  public enum SimplesNacionalEnum {
    SIM("Sim"),
    NAO("Não");

    private final String value;

    SimplesNacionalEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return value;
    }

    @JsonCreator
    public static SimplesNacionalEnum fromValue(String text) {
      for (SimplesNacionalEnum b : SimplesNacionalEnum.values()) {
        if (b.value.equalsIgnoreCase(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Valor inválido para SimplesNacionalEnum: " + text);
    }
  }
}