package com.example.Centro_Vac.Administracao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "administracao")
public class AdministracaoController {
    private final AdministracaoService administracaoService;

    @Autowired
    public AdministracaoController(AdministracaoService administracaoService) {
        this.administracaoService = administracaoService;
    }

    @GetMapping
    public List<Administracao> getAdministracao() {
        return administracaoService.getAdministracao();
    }

    @PostMapping
    public void registerNewAdministracao(@RequestBody Administracao administracao) {
        administracaoService.addNewAdministracao(administracao);
    }

    @DeleteMapping(path = "{administracaoId}")
    public void deleteAdministracao(@PathVariable("administracaoId") Long id) {
        administracaoService.deleteAdministracao(id);
    }

    @PutMapping(path = "{administracaoId}")
    public void updateAdministracao(@PathVariable("administracaoId") Long id) {
        administracaoService.updateAdministracao(id);
    }
}
