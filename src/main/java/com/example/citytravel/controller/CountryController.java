package com.example.citytravel.controller;

import com.example.citytravel.model.Country;
import com.example.citytravel.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/country")
@CrossOrigin("*")
public class CountryController {
    @Autowired
    private ICountryService countryService;
    @GetMapping("/list")
    public ResponseEntity<Iterable<Country>> list(){
        return new ResponseEntity<>(countryService.findAll(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Country> createCategory(@RequestBody Country country){
        return new ResponseEntity<>(countryService.save(country), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id){
        Optional<Country> countryOptional = countryService.findById(id);
        if (!countryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(countryOptional.get(),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Country> updateCategory(@RequestBody Country country) {
        return new ResponseEntity<>(countryService.save(country), HttpStatus.OK);
    }
}
