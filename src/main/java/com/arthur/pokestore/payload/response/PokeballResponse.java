package com.arthur.pokestore.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter@Setter
public class PokeballResponse {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private Integer quantity;

    public PokeballResponse(Long id, String name, BigDecimal price, String description, Integer quantity){
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }
}
