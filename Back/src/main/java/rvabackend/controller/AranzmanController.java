package rvabackend.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import rvabackend.model.Aranzman;
import rvabackend.service.AranzmanService;

@CrossOrigin
@RestController
public class AranzmanController {

    @Autowired
    private AranzmanService aranzmanService;
    

    @GetMapping("/aranzman")
    public List<Aranzman> getAllAranzman() {
        return aranzmanService.getAll();
    }

    @GetMapping("/aranzman/{id}")
    public ResponseEntity<Aranzman> getOne(@PathVariable("id") Integer id) {
        Optional<Aranzman> aranzman = aranzmanService.findById(id);
        return aranzman.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/aranzman/placeno")
    public List<Aranzman> getPlaceniAranzman() {
        return aranzmanService.findByPlacenoTrue();
    }

    @GetMapping("/aranzman/agencija/{id}")
    public ResponseEntity<List<Aranzman>> getAranzmaniByAgencijaId(@PathVariable("id") Integer agencijaId) {
        List<Aranzman> aranzmaniByAgencija = aranzmanService.findByAgencija_Id(agencijaId);
        return ResponseEntity.ok(aranzmaniByAgencija);
    }
    
    @GetMapping("/aranzman/hotel/{naziv}")
    public List<Aranzman> getAranzmaniByHotelNaziv(@PathVariable("naziv") String naziv) {
        return aranzmanService.findByNazivHotelContainingIgnoreCase(naziv);
    }

    @PostMapping("/aranzman")
    public ResponseEntity<Aranzman> addAranzman(@RequestBody Aranzman aranzman) {
        Aranzman savedAranzman = aranzmanService.save(aranzman);
        URI location = URI.create("/api/aranzmani/" + savedAranzman.getId());
        return ResponseEntity.created(location).body(savedAranzman);
    }

    @PutMapping("/aranzman/{id}")
    public ResponseEntity<Aranzman> updateAranzman(@RequestBody Aranzman aranzman, @PathVariable("id") Integer id) {
        if (aranzmanService.existById(id)) {
            aranzman.setId(id);
            Aranzman updatedAranzman = aranzmanService.save(aranzman);
            return ResponseEntity.ok(updatedAranzman);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/aranzman/{id}")
    public ResponseEntity<HttpStatus> deleteAranzman(@PathVariable("id") Integer id) {
        if (aranzmanService.existById(id)) {
            aranzmanService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
