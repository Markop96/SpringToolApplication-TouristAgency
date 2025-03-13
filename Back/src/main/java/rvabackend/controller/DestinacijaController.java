package rvabackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import rvabackend.model.Destinacija;
import rvabackend.service.DestinacijaService;

@CrossOrigin
@RestController
public class DestinacijaController {

    @Autowired
    private DestinacijaService destinacijaService;
    
    @GetMapping("/destinacija")
    public List<Destinacija> getAll() {
        return destinacijaService.getAll();
    }

    @GetMapping("/destinacija/{id}")
    public Destinacija getById(@PathVariable Integer id) {
        return destinacijaService.findById(id);
    }

    @GetMapping("/destinacija/drzava/{drzava}")
    public List<Destinacija> getByDrzava(@PathVariable String drzava) {
        return destinacijaService.findByDrzavaContainingIgnoreCase(drzava);
    }

    @PostMapping("/destinacija")
    public Destinacija addDestinacija(@RequestBody Destinacija destinacija) {
        return destinacijaService.save(destinacija);
    }
    @PutMapping("/destinacija/{id}")
	public ResponseEntity<Destinacija> updateDestinacija(@RequestBody Destinacija destinacija, @PathVariable("id") Integer id) {
		if(destinacijaService.existById(id)) {
			destinacija.setId(id);
			Destinacija savedDestincaija = destinacijaService.save(destinacija);
			return ResponseEntity.ok().body(savedDestincaija);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
    @DeleteMapping("/destinacija/{id}")
    public void deleteDestinacija(@PathVariable Integer id) {
        destinacijaService.deleteById(id);
    }
}
