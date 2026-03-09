package com.arthur.pokestore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PokeballException extends RuntimeException {
    public PokeballException(Long id, String message) {
        super(String.format("Failed for [%s]: %s", id, message));
    }

    public PokeballException(String name, String message) {
        super(String.format("Failed for [%s]: %s", name, message));
    }
}
