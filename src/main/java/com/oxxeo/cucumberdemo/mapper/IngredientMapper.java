package com.oxxeo.cucumberdemo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.oxxeo.cucumberdemo.dao.entity.Ingredient;
import com.oxxeo.cucumberdemo.dto.IngredientDto;
/**
 * Mapper des ingrédients
 * @author an.timonnier
 *
 */
@Mapper
public abstract class IngredientMapper {
	
	public abstract IngredientDto toDto(Ingredient entity);
	
	public abstract List<IngredientDto> toDtos(List<Ingredient> entities);
	
	public abstract Ingredient toEntity(IngredientDto dto);
	
	public abstract List<Ingredient> toEntities(List<IngredientDto> dtos);
	
	
	


}
