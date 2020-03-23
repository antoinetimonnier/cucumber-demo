package com.oxxeo.cucumberdemo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.oxxeo.cucumberdemo.dao.entity.Cocktail;
import com.oxxeo.cucumberdemo.dto.CocktailDto;
/**
 * Mapper des cocktails
 * @author an.timonnier
 *
 */
@Mapper(uses=IngredientMapper.class)
public abstract class CocktailMapper {

	public abstract CocktailDto toDto(Cocktail entity);
	
	public abstract List<CocktailDto> toDtos(List<Cocktail> entities);
	
	public abstract Cocktail toEntity(CocktailDto dto);
	
	public abstract List<Cocktail> toEntities(List<CocktailDto> dtos);
}
