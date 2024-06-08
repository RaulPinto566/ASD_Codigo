package com.example.Vacina.Vue;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VueService {
    private final VueRepository vueRepository;

    public VueService(VueRepository vueRepository) {
        this.vueRepository = vueRepository;
    }
    public List<Vue> getVue() {
        return vueRepository.findAll();
    }
    public List<Vue> getVuebyUtilizador(String utilizador) {
        return vueRepository.findVueBy_Utilizador(utilizador);
    }
    @Transactional
    public void updateVue(String utilizador,String centro,String marcacao) {
        vueRepository.save(new Vue(utilizador,centro,marcacao));
    }
}
