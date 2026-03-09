package com.arthur.pokestore.services;

import com.arthur.pokestore.entities.Pokeball;
import com.arthur.pokestore.exception.PokeballException;
import com.arthur.pokestore.payload.request.PokeballCreateRequest;
import com.arthur.pokestore.payload.request.PokeballUpdateRequest;
import com.arthur.pokestore.repositories.PokeballRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokeballService {

    @Autowired
    PokeballRepository pokeballRepository;

    @Transactional
    public Pokeball findPokeballById(Long id) {
        return pokeballRepository.findById(id)
                .orElseThrow(()-> new PokeballException(id,"Pokeball not found"));
    }

    @Transactional
    public void addPokeball(PokeballCreateRequest request) {

        if(pokeballRepository.existsByName(request.getName())) {
            throw new PokeballException(request.getName(),"Name is already taken!");
        }

        Pokeball pokeball = Pokeball.builder()
                .name(request.getName())
                .price(request.getPrice())
                .description(request.getDescription())
                .quantity(request.getQuantity())
                .build();

        pokeballRepository.save(pokeball);
    }

    @Transactional
    public void updatePokeball(Long id,PokeballUpdateRequest request) {

        Pokeball pokeball = pokeballRepository.findById(id)
                .orElseThrow(()-> new PokeballException(id, "Pokeball not found"));

        if (request.getName() != null && !request.getName().equals(pokeball.getName())) {
            if (pokeballRepository.existsByName(request.getName())) {
                throw new PokeballException(id, "Name '" + request.getName() + "' is already taken!");
            }
            pokeball.setName(request.getName());
        }

        if (request.getPrice() != null) pokeball.setPrice(request.getPrice());
        if (request.getDescription() != null) pokeball.setDescription(request.getDescription());
        if (request.getQuantity() != null) pokeball.setQuantity(request.getQuantity());

        pokeballRepository.save(pokeball);
    }

    @Transactional
    public void deletePokeball(Long id) {
        if(!pokeballRepository.existsById(id)){
            throw new PokeballException(id, "Pokeball not found");
        }
        pokeballRepository.deleteById(id);
    }
}
