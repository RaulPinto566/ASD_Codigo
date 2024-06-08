package com.example.Centro_Vac.Centro_vac;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Centro_VacService {
    private final com.example.Centro_Vac.Centro_vac.Centro_VacRepository centroVacRepository;

    public Centro_VacService(com.example.Centro_Vac.Centro_vac.Centro_VacRepository centroVacRepository) {
        this.centroVacRepository = centroVacRepository;
    }

    public List<Centro_Vac> getCentro_Vac() {
        return centroVacRepository.findAll();
    }
    public String getCentro_Vac(String nome) {
        return centroVacRepository.findCentro_VacBy_NOME(nome).getId().toString();
    }
    public String getCentro_Vac_Localidade(String localidade) {
        List<Centro_Vac> centros = centroVacRepository.findCentro_VacBy_LOACALIDADE(localidade);
        String fin = "";
        for (Centro_Vac centro : centros) {
            fin = fin + "\n" + centro.toString();
        }
        return fin;
    }
    public void addNewCentro_Vac(Centro_Vac centro) {
        Optional<Centro_Vac> centroByNome = centroVacRepository.findCentro_VacBy_NOM(centro.getNome());
        if (centroByNome.isPresent()) {
            throw new IllegalStateException("Já existe um centro com esse nome");
        }
        centroVacRepository.save(centro);
    }

    public void deleteCentro_Vac(Long id) {
        if (!centroVacRepository.existsById(id)) {
            throw new IllegalStateException("centro_vac with id " + id + " does not exist");
        }
        centroVacRepository.deleteById(id);
    }

    @Transactional
    public void updateCentro_Vac(Long id) {
        Centro_Vac centroVac = centroVacRepository.findById(id).orElseThrow(() -> new IllegalStateException("centro_vac with id " + id + " does not exist"));

    }
}
