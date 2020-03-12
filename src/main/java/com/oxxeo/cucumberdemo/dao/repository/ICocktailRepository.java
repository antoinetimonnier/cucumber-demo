package com.oxxeo.cucumberdemo.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oxxeo.cucumberdemo.dao.entity.Cocktail;
import com.oxxeo.cucumberdemo.dao.entity.Ingredient;
/**
 * Repository de l'entité {@link Cocktail}
 * @author an.timonnier
 *
 */
public interface ICocktailRepository extends JpaRepository<Cocktail, Integer>{

	/**
	 * Récupère le cocktail correspondant au nom et au prix passé en paramètre
	 * @param nom nom du cocktail
	 * @param prix prix du cocktail
	 * @return le cocktail correspondant au nom et au prix passé en paramètre
	 */
	Cocktail findByNomAndPrix(String nom, Long prix);
	
	/**
	 * Méthode pour récupérer l'ensemble des cocktails contenant un ingrédient passé en paramètre
	 * @param ingredient l'ingrédient pour filtrer la liste des cocktails
	 * @return l'ensemble des cocktails contenant un ingrédient passé en paramètre
	 */
	List<Cocktail> findByIngredients(Ingredient ingredient);
}
