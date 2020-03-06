package com.oxxeo.cucumberdemo.mapper;

import java.util.List;
import java.util.Optional;

import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.oxxeo.cucumberdemo.dao.entity.Cocktail;
import com.oxxeo.cucumberdemo.dao.entity.Ingredient;
import com.oxxeo.cucumberdemo.dao.repository.ICocktailRepository;
import com.oxxeo.cucumberdemo.dto.IngredientDto;

@Mapper
public abstract class IngredientMapper {
	
	@Mapping(source="cocktail.id", target="idCocktail")
	public abstract IngredientDto toDto(Ingredient entity);
	
	public abstract List<IngredientDto> toDtos(List<Ingredient> entities);
	
	public abstract Ingredient toEntity(IngredientDto dto, @Context ICocktailRepository cocktailRepository);
	
	public abstract List<Ingredient> toEntities(List<IngredientDto> dtos);
	
	@AfterMapping
	public void map(@MappingTarget Ingredient entity, IngredientDto dto, @Context ICocktailRepository cocktailRepository) {
		Optional<Cocktail> optionalCocktail = cocktailRepository.findById(dto.getIdCocktail());
		if(optionalCocktail.isPresent()) {
			entity.setCocktail(optionalCocktail.get());
		}
	}

}
