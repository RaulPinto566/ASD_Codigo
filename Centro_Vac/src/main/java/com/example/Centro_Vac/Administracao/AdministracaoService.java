package com.example.Centro_Vac.Administracao;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministracaoService {
    private final AdministracaoRepository administracaoRepository;

    public AdministracaoService(AdministracaoRepository administracaoRepository) {
        this.administracaoRepository = administracaoRepository;
    }

    public List<Administracao> getAdministracao() {
        return administracaoRepository.findAll();
    }

    public void addNewAdministracao(Administracao administracao) {
        administracaoRepository.save(administracao);
    }

    public void deleteAdministracao(Long id) {
        if (!administracaoRepository.existsById(id)) {
            throw new IllegalStateException("administracao with id " + id + " does not exist");
        }
        administracaoRepository.deleteById(id);
    }

    @Transactional
    public void updateAdministracao(Long id) {
        Administracao administracao = administracaoRepository.findById(id).orElseThrow(() -> new IllegalStateException("administracao with id " + id + " does not exist"));
    }
}
