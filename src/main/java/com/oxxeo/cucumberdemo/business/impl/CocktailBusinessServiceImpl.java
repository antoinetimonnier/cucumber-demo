package com.oxxeo.cucumberdemo.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oxxeo.cucumberdemo.business.ICocktailBusinessService;
import com.oxxeo.cucumberdemo.dao.entity.Cocktail;
import com.oxxeo.cucumberdemo.dao.repository.ICocktailRepository;

/**
 * Implémentation du service de récupération de l'objet {@link Cocktail}
 * @author an.timonnier
 *
 */
@Service
public class CocktailBusinessServiceImpl implements ICocktailBusinessService{
	
	@Autowired
	private ICocktailRepository cocktailRepository;

	@Override
	public List<Cocktail> getAllCocktails() {
		return cocktailRepository.findAll();
	}
	
	@Override
	public Cocktail save(Cocktail cocktail) {
		return cocktailRepository.save(cocktail);
	}
}
