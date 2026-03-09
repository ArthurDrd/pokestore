package com.arthur.pokestore.controllers;

import com.arthur.pokestore.entities.Pokeball;
import com.arthur.pokestore.payload.request.PokeballCreateRequest;
import com.arthur.pokestore.payload.request.PokeballUpdateRequest;
import com.arthur.pokestore.payload.response.MessageResponse;
import com.arthur.pokestore.repositories.PokeballRepository;
import com.arthur.pokestore.services.PokeballService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/pokeballs")
public class PokeballController {

    @Autowired
    private PokeballRepository pokeballRepository;
    @Autowired
    private PokeballService pokeballService;

    @GetMapping
    public List<Pokeball> getAllPokeballs() {
        return pokeballRepository.findAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addPokeball(@Valid @RequestBody PokeballCreateRequest request){

        pokeballService.addPokeball(request);
        return ResponseEntity.ok(new MessageResponse("Pokeball added successfully!"));
    }

    @PatchMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updatePokeball(@Valid @RequestBody PokeballUpdateRequest request){

        pokeballService.updatePokeball(request);
        return ResponseEntity.ok(new MessageResponse("Pokeball updated successfully!"));
    }
}
