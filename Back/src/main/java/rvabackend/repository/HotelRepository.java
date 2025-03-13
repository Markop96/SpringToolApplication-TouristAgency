package rvabackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rvabackend.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>{

	List<Hotel> findByNazivContainingIgnoreCase(String naziv);
    List<Hotel> findByBrojZvezdica(int brojZvezdica);
    List<Hotel> findByDestinacija_Drzava(String drzava);
    List<Hotel> findByDestinacija_DrzavaAndDestinacija_Mesto(String drzava, String mesto);
}
