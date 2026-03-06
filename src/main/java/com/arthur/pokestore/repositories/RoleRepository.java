package com.arthur.pokestore.repositories;

import com.arthur.pokestore.entities.ERole;
import com.arthur.pokestore.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {

    Optional<Role> findByName(ERole name);
}
