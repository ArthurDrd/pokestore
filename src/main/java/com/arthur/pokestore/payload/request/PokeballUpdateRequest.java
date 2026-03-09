package com.arthur.pokestore.payload.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter@Setter
public class PokeballUpdateRequest {

    @Size(max = 40)
    private String name;

    @Min(0)
    private BigDecimal price;

    @Size(max = 400)
    private String description;

    @Min(0)
    private Integer quantity;
}
