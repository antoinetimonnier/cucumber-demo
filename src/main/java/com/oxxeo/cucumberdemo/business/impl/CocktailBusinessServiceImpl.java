package com.oxxeo.cucumberdemo.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oxxeo.cucumberdemo.business.ICocktailBusinessService;
import com.oxxeo.cucumberdemo.dao.entity.Cocktail;
import com.oxxeo.cucumberdemo.dao.entity.Ingredient;
import com.oxxeo.cucumberdemo.dao.repository.CocktailRepository;
import com.oxxeo.cucumberdemo.dao.repository.IngredientRepository;
import com.oxxeo.cucumberdemo.dto.CocktailDto;
import com.oxxeo.cucumberdemo.dto.IngredientDto;
import com.oxxeo.cucumberdemo.exceptions.ExistingCocktailException;
import com.oxxeo.cucumberdemo.exceptions.IngredientNotFoundException;
import com.oxxeo.cucumberdemo.mapper.CocktailMapper;
import com.oxxeo.cucumberdemo.mapper.IngredientMapper;

/**
 * Implémentation du service de récupération de l'objet {@link Cocktail}
 * @author an.timonnier
 *
 */
@Service
public class CocktailBusinessServiceImpl implements ICocktailBusinessService {

	@Autowired
	private CocktailRepository cocktailRepository;

	@Autowired
	private CocktailMapper cocktailMapper;

	@Autowired
	private IngredientMapper ingredientMapper;

	@Autowired
	private IngredientRepository ingredientRepository;

	@Override
	public List<CocktailDto> getAllCocktails() {
		return cocktailMapper.toDtos(cocktailRepository.findAll());
	}

	@Override
	public CocktailDto save(CocktailDto cocktailDto) throws ExistingCocktailException {
		Cocktail alreadyExistingCocktail = cocktailRepository.findByNomAndPrix(cocktailDto.getNom(), cocktailDto.getPrix());
		if (alreadyExistingCocktail != null) {
			throw new ExistingCocktailException(cocktailDto);
		}
		cocktailDto.getIngredients().stream().forEach(ingredientDto -> {
			Ingredient alreadyExistingIngredient = ingredientRepository.findByNomAndContainsAlcool(ingredientDto.getNom(), ingredientDto.isContainsAlcool());
			if (alreadyExistingIngredient == null) {
				// Si l'ingrédient n'existe pas on créer le nouvel ingrédient
				Ingredient ingredientAfterSave = ingredientRepository.save(ingredientMapper.toEntity(ingredientDto));
				ingredientDto.setId(ingredientAfterSave.getId());
			} else {
				ingredientDto.setId(alreadyExistingIngredient.getId());
			}
		});
		return cocktailMapper.toDto(cocktailRepository.save(cocktailMapper.toEntity(cocktailDto)));
	}

	@Override
	public List<CocktailDto> getAllCocktailsWithIngredient(IngredientDto ingredientDto) throws IngredientNotFoundException {
		Ingredient ingredient = ingredientRepository.findByNomAndContainsAlcool(ingredientDto.getNom(), ingredientDto.isContainsAlcool());
		if (ingredient == null) {
			throw new IngredientNotFoundException(ingredientDto);
		}
		return cocktailMapper.toDtos(cocktailRepository.findByIngredients(ingredient));
	}

}
