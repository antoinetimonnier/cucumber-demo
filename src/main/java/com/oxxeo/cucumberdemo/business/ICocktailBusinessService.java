package com.oxxeo.cucumberdemo.business;

import java.util.List;

import com.oxxeo.cucumberdemo.dao.entity.Cocktail;

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
	public List<Cocktail> getAllCocktails();
}
