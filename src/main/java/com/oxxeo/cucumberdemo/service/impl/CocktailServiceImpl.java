package com.oxxeo.cucumberdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.oxxeo.cucumberdemo.business.ICocktailBusinessService;
import com.oxxeo.cucumberdemo.dto.CocktailDto;
import com.oxxeo.cucumberdemo.dto.IngredientDto;
import com.oxxeo.cucumberdemo.exceptions.ExistingCocktailException;
import com.oxxeo.cucumberdemo.exceptions.IngredientNotFoundException;
import com.oxxeo.cucumberdemo.service.ICocktailService;

/**
 * Implémentation du service REST des {@link CocktailDto}
 * @author an.timonnier
 *
 */
@RestController
public class CocktailServiceImpl implements ICocktailService {

	@Autowired
	private ICocktailBusinessService cocktailBusinessService;

	@Override
	public List<CocktailDto> getCocktails() {
		return cocktailBusinessService.getAllCocktails();
	}

	@Override
	public CocktailDto saveCocktail(CocktailDto cocktail) throws ExistingCocktailException {
		return cocktailBusinessService.save(cocktail);
	}

	@Override
	public List<CocktailDto> getCocktailsWithIngredient(IngredientDto ingredient) throws IngredientNotFoundException {
		return cocktailBusinessService.getAllCocktailsWithIngredient(ingredient);
	}

}
