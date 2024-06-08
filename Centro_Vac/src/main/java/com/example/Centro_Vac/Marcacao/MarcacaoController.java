package com.example.Centro_Vac.Marcacao;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(path = "marcacao")
public class MarcacaoController {
    private final MarcacaoService marcacaoService;
    private final RestTemplate restTemplate;

    public MarcacaoController(MarcacaoService marcacaoService, RestTemplate restTemplate) {
        this.marcacaoService = marcacaoService;
        this.restTemplate = restTemplate;
    }
    @GetMapping
    public List<Marcacao> getMarcacao() {
        return marcacaoService.getMarcacao();
    }

    @GetMapping("/utilizador")
    public String getMarcacao_utilizador(@RequestParam String utilizador) {
        return marcacaoService.getMarcacao_Utilizador(utilizador);
    }

    @PostMapping
    public void registerNewMarcacao(@RequestBody Marcacao marcacao) {
        String url = "lb://centrovac/centro_vac/all";
        marcacaoService.addNewMarcacao(marcacao, restTemplate.getForObject(url, String.class));
    }

    @DeleteMapping(path = "{marcacaoId}")
    public void deleteMarcacao(@PathVariable("marcacaoId") Long id) {
        marcacaoService.deleteMarcacao(id);
    }

    @PutMapping(path = "{marcacaoId}")
    public void updateMarcacao(@PathVariable("marcacaoId}") Long id) {
        marcacaoService.updateMarcacao(id);
    }
}