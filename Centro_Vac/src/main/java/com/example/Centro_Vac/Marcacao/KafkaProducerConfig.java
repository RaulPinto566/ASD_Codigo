package com.example.Centro_Vac.Marcacao;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerConfig {

    private static final String TOPIC = "marcacoes";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerConfig(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarJsonParaKafka(String json) {
        kafkaTemplate.send(TOPIC, json);
    }
}
