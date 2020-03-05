package com.oxxeo.cucumberdemo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.oxxeo.cucumberdemo.dao.entity.Cocktail;
import com.oxxeo.cucumberdemo.dto.CocktailDto;

@Mapper(uses=IngredientMapper.class)
public interface CocktailMapper {

	public CocktailDto toDto(Cocktail entity);
	
	public List<CocktailDto> toDtos(List<Cocktail> entities);
}
