package com.arthur.pokestore.payload.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter@Setter
public class PokeballCreateRequest {

    @NotBlank
    @Size(min = 3, max = 40)
    private String name;

    @NotNull
    @Min(0)
    private BigDecimal price;

    @NotBlank
    @Size(max = 400)
    private String description;

    @NotNull
    @Min(0)
    private Integer quantity;
}
