package com.consulta.credito.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetalhesCredito {

  @NotNull
  private String numeroCredito;

  @NotNull
  private String numeroNfse;

  @NotNull
  @Valid
  private LocalDate dataConstituicao;

  @NotNull
  private Double valorIssqn;

  @NotNull
  private String tipoCredito;

  @NotNull
  private SimplesNacionalEnum simplesNacional;

  @NotNull
  private Double aliquota;

  @NotNull
  private Double valorFaturado;

  @NotNull
  private Double valorDeducao;

  @NotNull
  private Double baseCalculo;

  public enum SimplesNacionalEnum {
    SIM("Sim"),
    NAO("Não");

    private final String value;

    SimplesNacionalEnum(String value) {
      this.value = value;
    }

    @Override
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
      return null;
    }
  }
}