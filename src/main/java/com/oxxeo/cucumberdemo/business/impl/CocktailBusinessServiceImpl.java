package com.oxxeo.cucumberdemo.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.oxxeo.cucumberdemo.business.ICocktailBusinessService;
import com.oxxeo.cucumberdemo.dao.entity.Cocktail;
import com.oxxeo.cucumberdemo.dao.repository.CocktailRepository;

/**
 * Implémentation du service de récupération de l'objet {@link Cocktail}
 * @author an.timonnier
 *
 */
public class CocktailBusinessServiceImpl implements ICocktailBusinessService{
	
	@Autowired
	private CocktailRepository cocktailRepository;

	@Override
	public List<Cocktail> getAllCocktails() {
		return cocktailRepository.findAll();
	}

}
