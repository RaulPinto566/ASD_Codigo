package com.example.Vacina.Vacina;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class VacinasService {
    private final VacinasRepository vacinasRepository;

    public VacinasService(VacinasRepository vacinasRepository) {
        this.vacinasRepository = vacinasRepository;
    }

    public List<Vacinas> getVacinas() {
        return vacinasRepository.findAll();
    }

    public void addNewVacina(Vacinas vacina) {
        Optional<Vacinas> vacinaByNome = vacinasRepository.findVacinasBy_Nome(vacina.getNome());
        if (vacinaByNome.isPresent()) {
            throw new IllegalStateException("nome taken");
        }
        vacinasRepository.save(vacina);
    }

    public void deleteVacina(Long id) {
        if (!vacinasRepository.existsById(id)) {
            throw new IllegalStateException("vacina with id " + id + " does not exist");
        }
        vacinasRepository.deleteById(id);
    }

    @Transactional
    public void updateVacina(Long id, String nome, String quantidade, String tipo) {
        Vacinas vacina = vacinasRepository.findById(id).orElseThrow(() -> new IllegalStateException("vacina with id " + id + " does not exist"));
        if (nome != null && nome.length() > 0 && !Objects.equals(vacina.getNome(), nome)) {
            vacina.setNome(nome);
        }
    }
}
