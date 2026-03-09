package com.arthur.pokestore.repositories;

import com.arthur.pokestore.entities.Pokeball;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokeballRepository extends JpaRepository<Pokeball, Long> {

    Optional<Pokeball> findByName(String name);

    Boolean existsByName(String name);
}
