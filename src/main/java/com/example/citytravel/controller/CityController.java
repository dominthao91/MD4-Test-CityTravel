package com.example.citytravel.controller;

import com.example.citytravel.model.City;
import com.example.citytravel.service.city.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/city")
@CrossOrigin("*")
public class CityController {
    @Autowired
    private ICityService cityService;

    @GetMapping("/{id}")
    public ResponseEntity<City> findById(@PathVariable Long id) {
        Optional<City> city = cityService.findById(id);
        if (!city.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(city.get(), HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<Iterable<City>> showAllCity(){
        return new ResponseEntity<>(cityService.findAll(),HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<City> create(@RequestBody City city){
        cityService.save(city);
        return new ResponseEntity<>(city,HttpStatus.CREATED);
    }
    @PutMapping("")
    public ResponseEntity<City> update(@RequestBody City city){
        return new ResponseEntity<>(cityService.save(city),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<City>remove(@PathVariable Long id){
        cityService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
