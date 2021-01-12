package com.example.au.couchbasedemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.Cricket;
import com.example.au.couchbasedemo.repository.CricketRepository;

@RestController
public class CricketController {

	@Autowired
    CricketRepository cricketRepository;
	
	@PostMapping("/cricket")
    public Cricket addCricket(@RequestBody Cricket newCricket) {
        return cricketRepository.save(newCricket);
    }
	// Search the cricketer having runs greater than the specified value
	@GetMapping("/cricket/runs/{runs}")
    public List<Cricket> getCricketByRunsGreaterThan(@PathVariable int runs) {
        return (List<Cricket>) cricketRepository.findByRunsGreaterThan(runs);
	}
}
