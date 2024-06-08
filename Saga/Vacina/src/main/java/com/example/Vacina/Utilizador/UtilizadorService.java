//package com.example.Vacina.Utilizador;
//
//import jakarta.transaction.Transactional;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//
//public class UtilizadorService {
//    private final UtilizadorRepository utilizadorRepository;
//
//    public UtilizadorService(UtilizadorRepository utilizadorRepository) {
//        this.utilizadorRepository = utilizadorRepository;
//    }
//
//    public List<Utilizador> getUtilizador() {
//        return utilizadorRepository.findAll();
//    }
//
//    public void addNewUtilizador(Utilizador utilizador) {
//        utilizadorRepository.save(utilizador);
//    }
//
//    public void deleteUtilizador(Long id) {
//        if (!utilizadorRepository.existsById(id)) {
//            throw new IllegalStateException("utilizador with id " + id + " does not exist");
//        }
//        utilizadorRepository.deleteById(id);
//    }
//
//    @Transactional
//    public void updateUtilizador(Long id) {
//        Utilizador utilizador = utilizadorRepository.findById(id).orElseThrow(() -> new IllegalStateException("utilizador with id " + id + " does not exist"));
//
//    }
//}
