package rvabackend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rvabackend.model.Destinacija;
import rvabackend.repository.DestinacijaRepository;

@Service
public class DestinacijaService {

    @Autowired
    private DestinacijaRepository destinacijaRepository;

    public List<Destinacija> getAll() {
        return destinacijaRepository.findAll();
    }

    public Destinacija findById(Integer id) {
        return destinacijaRepository.findById(id).orElse(null);
    }

    public List<Destinacija> findByDrzavaContainingIgnoreCase(String drzava) {
        return destinacijaRepository.findByDrzavaContainingIgnoreCase(drzava);
    }

    public Destinacija save(Destinacija destinacija) {
        return destinacijaRepository.save(destinacija);
    }

    public boolean existById(Integer id) {
        return destinacijaRepository.existsById(id);
    }

    public void deleteById(Integer id) {
        destinacijaRepository.deleteById(id);
    }
}
