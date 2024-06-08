package com.example.Centro_Vac.Centro_vac;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "centro_vac")
public class Centro_VacController {
    private final Centro_VacService centroVacService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public Centro_VacController(Centro_VacService centroVacService) {
        this.centroVacService = centroVacService;
    }

    @GetMapping("/all")
    public List<Centro_Vac> getCentro_Vac() {
        return centroVacService.getCentro_Vac();
    }

    @GetMapping("/nome")
    public String getCentro_Vac(@RequestParam String nome) {
        return centroVacService.getCentro_Vac(nome);
    }
    @GetMapping("/localidade")
    public String getCentro_Vac_Localidade(@RequestParam String localidade) {
        return centroVacService.getCentro_Vac_Localidade(localidade);
    }
    @PostMapping
    public void registerNewCentro_Vac(@RequestBody String centroVac) {
        Centro_Vac centro = null;
        try {
            centro = objectMapper.readValue(centroVac, Centro_Vac.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        centroVacService.addNewCentro_Vac(centro);
    }
    @DeleteMapping(path = "{centro_vacId}")
    public void deleteCentro_Vac(@PathVariable("centro_vacId") Long id) {
        centroVacService.deleteCentro_Vac(id);
    }

    @PutMapping(path = "{centro_vacId}")
    public void updateCentro_Vac(@PathVariable("centro_vacId") Long id) {
        centroVacService.updateCentro_Vac(id);
    }


}
