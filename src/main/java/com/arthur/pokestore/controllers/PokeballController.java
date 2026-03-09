package com.arthur.pokestore.controllers;

import com.arthur.pokestore.config.PokeballMapper;
import com.arthur.pokestore.entities.Pokeball;
import com.arthur.pokestore.payload.request.PokeballCreateRequest;
import com.arthur.pokestore.payload.request.PokeballUpdateRequest;
import com.arthur.pokestore.payload.response.MessageResponse;
import com.arthur.pokestore.payload.response.PokeballResponse;
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

    @Autowired
    private PokeballMapper pokeballMapper;

    @GetMapping
    public List<PokeballResponse> getAllPokeballs() {
        return pokeballMapper.toResponseList(pokeballRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPokeballById(@PathVariable Long id) {
        Pokeball pokeball = pokeballService.findPokeballById(id);
        return ResponseEntity.ok(new PokeballResponse(
                pokeball.getId(),
                pokeball.getName(),
                pokeball.getPrice(),
                pokeball.getDescription(),
                pokeball.getQuantity()));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addPokeball(@Valid @RequestBody PokeballCreateRequest request){

        pokeballService.addPokeball(request);
        return ResponseEntity.ok(new MessageResponse("Pokeball added successfully!"));
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updatePokeball(@PathVariable Long id, @Valid @RequestBody PokeballUpdateRequest request){

        pokeballService.updatePokeball(id, request);
        return ResponseEntity.ok(new MessageResponse("Pokeball updated successfully!"));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deletePokeball(@PathVariable Long id){

        pokeballService.deletePokeball(id);
        return ResponseEntity.ok(new MessageResponse("Pokeball deleted successfully!"));
    }
}
