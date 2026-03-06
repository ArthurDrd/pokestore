package com.arthur.pokestore.config;

import com.arthur.pokestore.entities.ERole;
import com.arthur.pokestore.entities.Role;
import com.arthur.pokestore.entities.User;
import com.arthur.pokestore.repositories.RoleRepository;
import com.arthur.pokestore.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class DataInitializer implements ApplicationRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        initRole(ERole.ROLE_USER);
        initRole(ERole.ROLE_MODERATOR);
        initRole(ERole.ROLE_ADMIN);

        if (!userRepository.existsByUsername("admin")) {
            Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error : The ADMIN role has not been initialized."));

            User admin = new User("admin", "admin@poke.com", passwordEncoder.encode("admin123"));
            admin.setRoles(Set.of(adminRole));
            userRepository.save(admin);
        }
    }

    private void initRole(ERole name) {
        if (roleRepository.findByName(name).isEmpty()) {
            roleRepository.save(new Role(name));
        }
    }
}
