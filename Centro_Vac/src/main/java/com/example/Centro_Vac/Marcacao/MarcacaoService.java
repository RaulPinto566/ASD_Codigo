package com.example.Centro_Vac.Marcacao;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import org.springframework.kafka.core.KafkaTemplate;

@Service
public class MarcacaoService {
    private static final String TOPIC = "marcacoes";
    private final KafkaTemplate<String, String> kafkaTemplate;
    public void enviarJsonParaKafka(String json) {
        kafkaTemplate.send(TOPIC, json);
    }
    private final MarcacaoRepository marcacaoRepository;
    public MarcacaoService(MarcacaoRepository marcacaoRepository,KafkaTemplate<String, String> kafkaTemplate) {
        this.marcacaoRepository = marcacaoRepository;
        this.kafkaTemplate = kafkaTemplate;
    }
    public List<Marcacao> getMarcacao() {
        return marcacaoRepository.findAll();
    }
    public String getMarcacao_Utilizador(String utilizador) {
        List<Marcacao> marcacaos = marcacaoRepository.findMarcacaoBy_Utilizador(utilizador);
        String fin = "";
        for (Marcacao marcacao : marcacaos) {
            fin = fin + "\n" + marcacao.toString();
        }
        return fin;
    }

    public void addNewMarcacao(Marcacao marcacao,String centros) {
        marcacaoRepository.save(marcacao);
        marcacao = marcacaoRepository.findMarcacaoBy_Utilizado(marcacao.getUtilizador());
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Map<String, Object>> jsonData = objectMapper.readValue(centros, List.class);
            for (Map<String, Object> centro : jsonData) {
                if ("braga".equals(centro.get("localidade"))) {
                    String Json = String.format("{\"utilizador\": \"%s\", \"centro\": \"%s\", \"marcacao\": \"%s\"}", marcacao.getUtilizador(), centro.get("nome"), marcacao.getId());
                    enviarJsonParaKafka(Json);
                    System.out.println("ID do centro em Braga: " + centro.get("id"));
                }
            }
        } catch (Exception e) {
            throw new IllegalStateException("Sou burro e dei merda porque sou burro.");
        }
    }

    public void deleteMarcacao(Long id) {
        if (!marcacaoRepository.existsById(id)) {
            throw new IllegalStateException("marcacao with id " + id + " does not exist");
        }
        marcacaoRepository.deleteById(id);
    }

    @Transactional
    public void updateMarcacao(Long id) {
        Marcacao marcacao = marcacaoRepository.findById(id).orElseThrow(() -> new IllegalStateException("marcacao with id " + id + " does not exist"));

    }

}
