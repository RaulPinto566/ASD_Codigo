package com.example.Utilizadores.Utilizador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "utilizador")
public class UtilizadorController {
    private final UtilizadorService utilizadorService;

    @Autowired
    public UtilizadorController(UtilizadorService utilizadorService) {
        this.utilizadorService = utilizadorService;
    }

    @GetMapping
    public List<Utilizador> getUtilizador() {
        return utilizadorService.getUtilizador();
    }
    @PostMapping
    public void registerNewUtilizador(@RequestBody Utilizador utilizador) {
        utilizadorService.addNewUtilizador(utilizador);
    }

    @DeleteMapping(path = "{utilizadorId}")
    public void deleteUtilizador(@PathVariable("utilizadorId") Long id) {
        utilizadorService.deleteUtilizador(id);
    }

    @PutMapping(path = "{utilizadorId}")
    public void updateUtilizador(@PathVariable("utilizadorId") Long id) {
        utilizadorService.updateUtilizador(id);
    }
}
