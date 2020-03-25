package com.oxxeo.cucumberdemo.business;

import java.util.List;

import com.oxxeo.cucumberdemo.dao.entity.Cocktail;
import com.oxxeo.cucumberdemo.dto.CocktailDto;
import com.oxxeo.cucumberdemo.dto.IngredientDto;
import com.oxxeo.cucumberdemo.exceptions.ExistingCocktailException;
import com.oxxeo.cucumberdemo.exceptions.IngredientNotFoundException;

/**
 * Interface du service business de récupération de l'objet {@link Cocktail}
 * @author an.timonnier
 *
 */
public interface ICocktailBusinessService {

	/**
	 * Méthode de récupération de la liste comportant l'ensemble des cocktails
	 * @return la liste comportant l'ensemble des cocktails
	 */
	public List<CocktailDto> getAllCocktails();

	/**
	 * Méthode d'enregistrement d'un cocktail
	 * @param cocktail le cocktail a enregistrer
	 * @return le cocktail enregistré
	 * @throws ExistingCocktailException 
	 */
	public CocktailDto save(CocktailDto cocktail) throws ExistingCocktailException;

	/**
	 * Méthode de récupération de la liste des cocktails comportant l'ingrédient passé en paramètre
	 * @param ingredient ingrédient pour filtrer la liste des cocktails
	 * @return la liste des cocktails comportant l'ingrédient passé en paramètre
	 * @throws IngredientNotFoundException 
	 */
	public List<CocktailDto> getAllCocktailsWithIngredient(IngredientDto ingredient) throws IngredientNotFoundException;
}
