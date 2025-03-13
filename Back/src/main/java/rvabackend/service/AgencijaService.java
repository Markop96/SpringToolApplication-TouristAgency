package rvabackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rvabackend.model.TuristickaAgencija;
import rvabackend.repository.AgencijaRepository;

@Service
public class AgencijaService {

	@Autowired
	private AgencijaRepository agencijaRepository;
	
	public List<TuristickaAgencija> getAll() {
		return agencijaRepository.findAll();
	}
	
	public Optional<TuristickaAgencija> findById(Integer id){
		return agencijaRepository.findById(id);
	}
	
	public List<TuristickaAgencija> findByNazivContainingIgnoreCase(String naziv){
		return agencijaRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	public TuristickaAgencija save (TuristickaAgencija agencija) {
		return agencijaRepository.save(agencija);
	}
	
	public boolean existById(Integer id) {
		return agencijaRepository.existsById(id);
	}
	
	public void deleteById(Integer id) {
		agencijaRepository.deleteById(id);
	}
}
