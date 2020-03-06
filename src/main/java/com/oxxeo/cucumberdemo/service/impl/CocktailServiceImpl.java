package com.oxxeo.cucumberdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.oxxeo.cucumberdemo.business.ICocktailBusinessService;
import com.oxxeo.cucumberdemo.dto.CocktailDto;
import com.oxxeo.cucumberdemo.mapper.ICocktailMapper;
import com.oxxeo.cucumberdemo.service.ICocktailService;

/**
 * Implémentation du service REST de récupération des {@link CocktailDto}
 * @author an.timonnier
 *
 */
@RestController
public class CocktailServiceImpl implements ICocktailService{
	
	@Autowired
	private ICocktailBusinessService cocktailBusinessService;
	
	@Autowired
	private ICocktailMapper cocktailMapper;

	@Override
	public List<CocktailDto> getCocktails() {
		return cocktailMapper.toDtos(cocktailBusinessService.getAllCocktails());
	}

	@Override
	public ResponseEntity<CocktailDto> saveCocktail(CocktailDto cocktail) {
		return new ResponseEntity<CocktailDto>(cocktailMapper.toDto(cocktailBusinessService.save(cocktailMapper.toEntity(cocktail))), HttpStatus.CREATED);
	}


}
