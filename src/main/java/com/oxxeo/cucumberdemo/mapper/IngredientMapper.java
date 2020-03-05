package com.oxxeo.cucumberdemo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.oxxeo.cucumberdemo.dao.entity.Ingredient;
import com.oxxeo.cucumberdemo.dto.IngredientDto;

@Mapper
public interface IngredientMapper {
	
	public IngredientDto toDto(Ingredient entity);
	
	public List<IngredientDto> toDtos(List<Ingredient> entities);

}
