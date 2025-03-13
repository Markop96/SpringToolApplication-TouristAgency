package rvabackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rvabackend.model.Aranzman;

@Repository
public interface AranzmanRepository extends JpaRepository<Aranzman, Integer>{

	List<Aranzman> findByAgencija_Id(Integer agencijaId);
	List<Aranzman> findByHotel_NazivContainingIgnoreCase(String naziv);
    List<Aranzman> findByPlacenoTrue();
}
