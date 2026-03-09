package com.arthur.pokestore.repositories;

import com.arthur.pokestore.entities.Pokeball;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokeballRepository extends JpaRepository<Pokeball, Long> {

    Boolean existsByName(String name);
}
