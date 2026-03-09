package com.arthur.pokestore.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter@Setter
public class PokeballResponse {
    private String name;
    private BigDecimal price;
    private String description;
    private Integer quantity;

    public PokeballResponse(String name, BigDecimal price, String description, Integer quantity){
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }
}
