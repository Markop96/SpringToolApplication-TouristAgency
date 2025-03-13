package rvabackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rvabackend.model.Hotel;
import rvabackend.repository.HotelRepository;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    public Optional<Hotel> findById(Integer id) {
        return hotelRepository.findById(id);
    }

    public List<Hotel> findByNazivContainingIgnoreCase(String naziv) {
        return hotelRepository.findByNazivContainingIgnoreCase(naziv);
    }

    public List<Hotel> findByBrojZvezdica(int brojZvezdica) {
        return hotelRepository.findByBrojZvezdica(brojZvezdica);
    }

    public List<Hotel> findByDrzava(String drzava) {
        return hotelRepository.findByDestinacija_Drzava(drzava);
    }

    public List<Hotel> findByDrzavaAndMesto(String drzava, String mesto) {
        return hotelRepository.findByDestinacija_DrzavaAndDestinacija_Mesto(drzava, mesto);
    }

    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public boolean existById(Integer id) {
        return hotelRepository.existsById(id);
    }

    public void deleteById(Integer id) {
        hotelRepository.deleteById(id);
    }
}
