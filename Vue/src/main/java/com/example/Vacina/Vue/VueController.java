package com.example.Vacina.Vue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "")
public class VueController {
    private final VueService vueService;

    @Autowired
    public VueController(VueService vueService) {
        this.vueService = vueService;
    }

    @GetMapping("/utilizador_centro")
    public List<Vue> getMarcacao_utilizador(@RequestParam String utilizador) {
        return vueService.getVuebyUtilizador(utilizador);
    }
}
