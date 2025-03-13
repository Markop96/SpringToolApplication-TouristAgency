package rvabackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rvabackend.model.Aranzman;
import rvabackend.repository.AranzmanRepository;


@Service
public class AranzmanService {

	@Autowired
	private AranzmanRepository aranzmanRepository;
	
	
	public List<Aranzman> getAll() {
		return aranzmanRepository.findAll();
	}
	
	public Optional<Aranzman> findById(Integer id){
		return aranzmanRepository.findById(id);
	}
	
	    
	public List<Aranzman> findByNazivHotelContainingIgnoreCase(String naziv) {
        return aranzmanRepository.findByHotel_NazivContainingIgnoreCase(naziv);
}

    public List<Aranzman> findByPlacenoTrue() {
        return aranzmanRepository.findByPlacenoTrue();
    }
	
	
	public Aranzman save (Aranzman aranzman) {
		return aranzmanRepository.save(aranzman);
	}
	
	public boolean existById(Integer id) {
		return aranzmanRepository.existsById(id);
	}
	
	public void deleteById(Integer id) {
		aranzmanRepository.deleteById(id);
	}

	public List<Aranzman> findByAgencija_Id(Integer agencijaId) {
        return aranzmanRepository.findByAgencija_Id(agencijaId);
    }
	
	
}
