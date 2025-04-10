package com.consulta.credito.test;

import com.consulta.credito.controller.ConsultaCreditoApiController;
import com.consulta.credito.dto.Credito;
import com.consulta.credito.dto.Credito.SimplesNacionalEnum;
import com.consulta.credito.messaging.EventoPublisher;
import com.consulta.credito.service.CreditoService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ConsultaCreditoApiTest {

	private final CreditoService creditoService = mock(CreditoService.class);
	private final EventoPublisher publisher = mock(EventoPublisher.class);
	private final ConsultaCreditoApiController controller = new ConsultaCreditoApiController(creditoService, publisher);

    private Credito criarCreditoMock() {
		return Credito.builder()
				.numeroCredito("123456")
				.numeroNfse("7891011")
				.dataConstituicao(LocalDate.of(2024, 2, 25))
				.valorIssqn(BigDecimal.valueOf(1500.75))
				.tipoCredito("ISSQN")
				.simplesNacional(SimplesNacionalEnum.SIM)
				.aliquota(BigDecimal.valueOf(5.0))
				.valorFaturado(BigDecimal.valueOf(30000.00))
				.valorDeducao(BigDecimal.valueOf(5000.00))
				.baseCalculo(BigDecimal.valueOf(25000.00))
				.build();
	}

	@Test
	void deveRetornarListaDeCreditosPorNumeroNfse() {
		String numeroNfse = "7891011";

		Credito credito = Credito.builder()
				.numeroCredito("123456")
				.numeroNfse(numeroNfse)
				.dataConstituicao(LocalDate.of(2024, 2, 25))
				.valorIssqn(BigDecimal.valueOf(1500.75))
				.tipoCredito("ISSQN")
				.simplesNacional(SimplesNacionalEnum.SIM)
				.aliquota(BigDecimal.valueOf(5.0))
				.valorFaturado(BigDecimal.valueOf(30000.00))
				.valorDeducao(BigDecimal.valueOf(5000.00))
				.baseCalculo(BigDecimal.valueOf(25000.00))
				.build();

		when(creditoService.consultarCreditoPorNumeroNfse(numeroNfse)).thenReturn(List.of(credito));

		ResponseEntity<List<Credito>> response = controller.getConsultaCreditos(numeroNfse);

		assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
		List<Credito> creditos = response.getBody();
        assert creditos != null;
        assertEquals(1, creditos.size());

		Credito c = creditos.get(0);
		assertEquals("123456", c.getNumeroCredito());
		assertEquals("7891011", c.getNumeroNfse());
		assertEquals(LocalDate.of(2024, 2, 25), c.getDataConstituicao());
		assertEquals(BigDecimal.valueOf(1500.75), c.getValorIssqn());
		assertEquals("ISSQN", c.getTipoCredito());
		assertEquals(SimplesNacionalEnum.SIM, c.getSimplesNacional());
		assertEquals(BigDecimal.valueOf(5.0), c.getAliquota());
		assertEquals(BigDecimal.valueOf(30000.00), c.getValorFaturado());
		assertEquals(BigDecimal.valueOf(5000.00), c.getValorDeducao());
		assertEquals(BigDecimal.valueOf(25000.00), c.getBaseCalculo());
	}

	@Test
	void deveRetornarDetalhesDoCreditoPorNumeroCredito() {
		String numeroCredito = "123456";
		Credito credito = criarCreditoMock();

		when(creditoService.consultarDetalhesCreditoPorNumeroCredito(numeroCredito))
				.thenReturn(Optional.of(credito));

		ResponseEntity<Credito> response = controller.getDetalhesCredito(numeroCredito);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		Credito c = response.getBody();
		assertNotNull(c);
		assertEquals("123456", c.getNumeroCredito());
		assertEquals("7891011", c.getNumeroNfse());
		assertEquals(LocalDate.of(2024, 2, 25), c.getDataConstituicao());
		assertEquals(BigDecimal.valueOf(1500.75), c.getValorIssqn());
		assertEquals("ISSQN", c.getTipoCredito());
		assertEquals(SimplesNacionalEnum.SIM, c.getSimplesNacional());
		assertEquals(BigDecimal.valueOf(5.0), c.getAliquota());
		assertEquals(BigDecimal.valueOf(30000.00), c.getValorFaturado());
		assertEquals(BigDecimal.valueOf(5000.00), c.getValorDeducao());
		assertEquals(BigDecimal.valueOf(25000.00), c.getBaseCalculo());
	}

	@Test
	void devePublicarEventoAoConsultarCreditoPorNumeroNfse() {
		String numeroNfse = "7891011";
		Credito credito = criarCreditoMock();
		when(creditoService.consultarCreditoPorNumeroNfse(numeroNfse)).thenReturn(List.of(credito));
		ResponseEntity<List<Credito>> response = controller.getConsultaCreditos(numeroNfse);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		verify(publisher, times(1)).publicarConsultaCredito(numeroNfse);
	}
}