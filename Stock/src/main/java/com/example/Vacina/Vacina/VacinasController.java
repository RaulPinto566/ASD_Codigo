package com.example.Vacina.Vacina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "vacina")
public class VacinasController {
    private final VacinasService vacinasService;

    @Autowired
    public VacinasController(VacinasService vacinasService) {
        this.vacinasService = vacinasService;
    }

    @GetMapping
    public List<Vacinas> getVacinas() {
        return vacinasService.getVacinas();
    }

    @PostMapping
    public void registerNewVacina(@RequestBody Vacinas vacina) {
        vacinasService.addNewVacina(vacina);
    }

    @DeleteMapping(path = "{vacinaId}")
    public void deleteVacina(@PathVariable("vacinaId") Long id) {
        vacinasService.deleteVacina(id);
    }

    @PutMapping(path = "{vacinaId}")
    public void updateVacina(@PathVariable("vacinaId") Long id, @RequestParam(required = false) String nome, @RequestParam(required = false) String quantidade, @RequestParam(required = false) String tipo) {
        vacinasService.updateVacina(id, nome, quantidade, tipo);
    }

    ;
}
