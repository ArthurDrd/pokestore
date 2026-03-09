package com.arthur.pokestore.config;

import com.arthur.pokestore.entities.Pokeball;
import com.arthur.pokestore.payload.request.PokeballUpdateRequest;
import com.arthur.pokestore.payload.response.PokeballResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PokeballMapper {

    PokeballResponse toResponse(Pokeball pokeball);

    List<PokeballResponse> toResponseList(List<Pokeball> pokeballs);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePokeballFromDto(PokeballUpdateRequest dto, @MappingTarget Pokeball entity);
}
