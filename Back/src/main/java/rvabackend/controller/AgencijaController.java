package rvabackend.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rvabackend.service.AgencijaService;
import rvabackend.model.TuristickaAgencija;

@CrossOrigin
@RestController
public class AgencijaController {
	
	@Autowired
	private AgencijaService agencijaService;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/agencija")
	public List<TuristickaAgencija> getAll() {
		return agencijaService.getAll();
	}
	
	@GetMapping("/agencija/{id}")
	public ResponseEntity<TuristickaAgencija> getOne(@PathVariable("id") Integer id) {
	    if (agencijaService.existById(id)) {
	        Optional<TuristickaAgencija> agencija = agencijaService.findById(id);
	        return new ResponseEntity<>(agencija.get(), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	    }
	}

	
	@GetMapping("/agencija/naziv/{naziv}")
	public ResponseEntity<List<TuristickaAgencija>> getByNaziv(@PathVariable("naziv") String naziv) {
		List<TuristickaAgencija> agencija = agencijaService.findByNazivContainingIgnoreCase(naziv);
		return new ResponseEntity<>(agencija, HttpStatus.OK);
	}
	
	@PostMapping("/agencija")
	public ResponseEntity<TuristickaAgencija> addTuristickaAgencija(@RequestBody TuristickaAgencija agencija) {
		TuristickaAgencija savedTuristickaAgencija = agencijaService.save(agencija);
		URI location = URI.create("/artikl/" + savedTuristickaAgencija.getId());
		return ResponseEntity.created(location).body(savedTuristickaAgencija);
	}
	
	@PutMapping("/agencija/{id}")
	public ResponseEntity<TuristickaAgencija> updateTuristickaArtikl(@RequestBody TuristickaAgencija agencija, @PathVariable("id") Integer id) {
		if(agencijaService.existById(id)) {
			agencija.setId(id);
			TuristickaAgencija savedTuristickaAgencija = agencijaService.save(agencija);
			return ResponseEntity.ok().body(savedTuristickaAgencija);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/agencija/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id){
		
		if(id == -100 && !agencijaService.existById(id)) {
			jdbcTemplate.execute("INSERT INTO TuristickaAgencija (\"id\", \"naziv\", \"adresa\",\"kontakt\") "
					+ " VALUES ( -100, 'Test proizvodjac', 'Test naziv','Test kontakt' )");
		}
		
		if(agencijaService.existById(id)) {
			agencijaService.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}

}
