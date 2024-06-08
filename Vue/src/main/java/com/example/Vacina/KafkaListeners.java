package com.example.Vacina;

import com.example.Vacina.Vue.VueService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    private final VueService vueService;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public KafkaListeners(VueService vueService, KafkaTemplate<String, Object> kafkaTemplate) {
        this.vueService = vueService;
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "marcacoes", groupId = "marcacaoid")
    void listenermarcacao(ConsumerRecord<String, String> record) {
        try {
            System.out.println("Putas " + record);
            ConstrutorVue vue = objectMapper.readValue(record.value(), ConstrutorVue.class);
            System.out.println(vue.toString());
            vueService.updateVue(vue.getUtilizador(),vue.getCentro(),vue.getMarcacao());
        } catch (Exception e) {
            System.err.println("Erro ao converter JSON para objeto Vue: " + e.getMessage());
        }
    }
}
