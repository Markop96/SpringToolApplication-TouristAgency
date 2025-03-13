package rvabackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rvabackend.model.Destinacija;

public interface DestinacijaRepository extends JpaRepository<Destinacija, Integer>{

    List<Destinacija> findByDrzavaContainingIgnoreCase(String drzava);
}
