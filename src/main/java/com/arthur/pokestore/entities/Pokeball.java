package com.arthur.pokestore.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "pokeballs",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "name")
        })
@Getter @Setter @NoArgsConstructor@AllArgsConstructor
public class Pokeball {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String name;

    @NotNull
    @Min(0)
    private BigDecimal price;

    @NotBlank
    private String description;

    @Min(0)
    @NotNull
    private Integer quantity;

    @Builder
    public Pokeball(String name, BigDecimal price,String description, Integer quantity) {

        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }
}
