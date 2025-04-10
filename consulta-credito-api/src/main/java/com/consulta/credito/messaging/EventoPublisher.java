package com.consulta.credito.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Service
public class EventoPublisher {

    private static final Logger logger = LogManager.getLogger(EventoPublisher.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPICO = "eventos.credito";

    public EventoPublisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publicarConsultaCredito(String numero) {
        Map<String, Object> evento = new HashMap<>();
        evento.put("evento", "CONSULTA_CREDITO");
        evento.put("numeroNfse", numero);
        evento.put("dataHora", Instant.now().toString());

        try {
            String json = new ObjectMapper().writeValueAsString(evento);
            kafkaTemplate.send(TOPICO, json);
        } catch (JsonProcessingException e) {
            logger.error("Erro ao serializar ou enviar mensagem para Kafka: {}", numero, e);
        }
    }
}