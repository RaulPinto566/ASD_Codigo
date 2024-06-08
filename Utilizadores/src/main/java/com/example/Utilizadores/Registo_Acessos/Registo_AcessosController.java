package com.example.Utilizadores.Registo_Acessos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "registo_acesso")
public class Registo_AcessosController {
    private final Registo_AcessosService registoacessosService;

    @Autowired
    public Registo_AcessosController(Registo_AcessosService registoacessosService) {
        this.registoacessosService = registoacessosService;
    }

    @GetMapping
    public List<Registo_Acessos> getRegisto_Acessos() {
        return registoacessosService.getRegistoAcessos();
    }

    @PostMapping
    public void registerNewRegisto_Acessos(@RequestBody Registo_Acessos registoAcessos) {
        registoacessosService.addNewRegisto_Acessos(registoAcessos);
    }

    @DeleteMapping(path = "{registoacessosId}")
    public void deleteRegisto_Acessos(@PathVariable("registoacessosId") Long id) {
        registoacessosService.deleteRegisto_Acessos(id);
    }

    @PutMapping(path = "{registoacessosId}")
    public void updateRegisto_Acessos(@PathVariable("registoacessosId") Long id) {
        registoacessosService.updateRegisto_Acessos(id);
    }
}
