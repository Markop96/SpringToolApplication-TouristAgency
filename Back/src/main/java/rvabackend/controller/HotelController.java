package rvabackend.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import rvabackend.model.Hotel;
import rvabackend.service.HotelService;

@RestController
@CrossOrigin
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("hotel")
    public ResponseEntity<List<Hotel>> getAll() {
        List<Hotel> hotels = hotelService.getAll();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("hotel/{id}")
    public ResponseEntity<Hotel> getOne(@PathVariable("id") Integer id) {
        Optional<Hotel> hotel = hotelService.findById(id);
        return hotel.isPresent() ? new ResponseEntity<>(hotel.get(), HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("hotel/zvezdice/{brojZvezdica}")
    public ResponseEntity<List<Hotel>> getByStars(@PathVariable int brojZvezdica) {
        List<Hotel> hotels = hotelService.findByBrojZvezdica(brojZvezdica);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("hotel/destinacija/{drzava}")
    public ResponseEntity<List<Hotel>> getByDrzava(@PathVariable String drzava) {
        List<Hotel> hotels = hotelService.findByDrzava(drzava);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("hotel/destinacija/{drzava}/{mesto}")
    public ResponseEntity<List<Hotel>> getByDrzavaAndMesto(@PathVariable String drzava, @PathVariable String mesto) {
        List<Hotel> hotels = hotelService.findByDrzavaAndMesto(drzava, mesto);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @PostMapping("hotel")
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
        Hotel savedHotel = hotelService.save(hotel);
        URI location = URI.create("/hotel/" + savedHotel.getId());
        return ResponseEntity.created(location).body(savedHotel);
    }

    @PutMapping("hotel/{id}")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel, @PathVariable("id") Integer id) {
        if (hotelService.existById(id)) {
            hotel.setId(id);
            Hotel savedHotel = hotelService.save(hotel);
            return ResponseEntity.ok().body(savedHotel);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("hotel/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        if (hotelService.existById(id)) {
            hotelService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
