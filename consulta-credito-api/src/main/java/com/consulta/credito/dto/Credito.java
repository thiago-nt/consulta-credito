package com.consulta.credito.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
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
  @Schema(example = "CR123456789")
  private String numeroCredito;

  @NotNull
  @Schema(example = "NFSE987654321")
  private String numeroNfse;

  @NotNull
  @Valid
  @Schema(example = "2024-04-01", type = "string", format = "date")
  private LocalDate dataConstituicao;

  @NotNull
  @Schema(example = "1500.00")
  private BigDecimal valorIssqn;

  @NotNull
  @Schema(example = "ISSQN")
  private String tipoCredito;

  @NotNull
  @Schema(example = "Sim", allowableValues = {"Sim", "Não"})
  private SimplesNacionalEnum simplesNacional;

  @NotNull
  @Schema(example = "0.05")
  private BigDecimal aliquota;

  @NotNull
  @Schema(example = "30000.00")
  private BigDecimal valorFaturado;

  @NotNull
  @Schema(example = "2000.00")
  private BigDecimal valorDeducao;

  @NotNull
  @Schema(example = "28000.00")
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