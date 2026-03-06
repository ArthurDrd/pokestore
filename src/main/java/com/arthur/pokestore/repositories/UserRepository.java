package com.arthur.pokestore.repositories;

import com.arthur.pokestore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    // Connexion
    Optional<User> findByUsername(String username);

    // Inscription
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
