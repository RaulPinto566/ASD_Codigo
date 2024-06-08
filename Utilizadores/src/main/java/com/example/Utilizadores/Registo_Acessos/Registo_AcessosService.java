package com.example.Utilizadores.Registo_Acessos;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class Registo_AcessosService {
    private final Registo_AcessosRepository registoacessosRepository;

    public Registo_AcessosService(Registo_AcessosRepository registoacessosRepository) {
        this.registoacessosRepository = registoacessosRepository;
    }

    public List<Registo_Acessos> getRegistoAcessos() {
        return registoacessosRepository.findAll();
    }

    public void addNewRegisto_Acessos(Registo_Acessos registoacessos) {
        registoacessosRepository.save(registoacessos);
    }

    public void deleteRegisto_Acessos(Long id) {
        if (!registoacessosRepository.existsById(id)) {
            throw new IllegalStateException("registo_acesso with id " + id + " does not exist");
        }
        registoacessosRepository.deleteById(id);
    }

    @Transactional
    public void updateRegisto_Acessos(Long id) {
        Registo_Acessos registoacessos = registoacessosRepository.findById(id).orElseThrow(() -> new IllegalStateException("registoacessos with id " + id + " does not exist"));

    }
}
