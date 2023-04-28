package com.example.elibrary.web;

import com.example.elibrary.model.Country;
import com.example.elibrary.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/countries")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    @GetMapping
    public List<Country> findAll(){
        return countryService.findAll();
    }
    @PostMapping("/save")
    public Country save(@RequestParam String name,
                        @RequestParam String continent){
        return countryService.save(name, continent);
    }
}
