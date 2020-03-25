package com.oxxeo.cucumberdemo.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oxxeo.cucumberdemo.dto.CocktailDto;
import com.oxxeo.cucumberdemo.dto.IngredientDto;
import com.oxxeo.cucumberdemo.exceptions.ExistingCocktailException;
import com.oxxeo.cucumberdemo.exceptions.IngredientNotFoundException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

/**
 * Service REST de récupération des {@link CocktailDto}
 * @author an.timonnier
 *
 */
@RequestMapping("/api/cocktails")
public interface ICocktailService {

	/**
	 * Méthode de récupération des cocktails
	 * @return la liste de l'ensemble des cocktails
	 */
	@GetMapping
	@Operation(summary = "Get cocktails", description = "Récupère l'ensemble des cocktails")
	public List<CocktailDto> getCocktails();

	/**
	 * Méthode d'enregistrement d'un cocktail
	 * @param cocktail cocktail à créer
	 * @return le cocktail créé
	 * @throws ExistingCocktailException 
	 */
	@PostMapping
	@Operation(summary = "Save cocktail", description = "Enregistre en base de données le cocktail passé en paramètre")
	public CocktailDto saveCocktail(@Parameter(description = "Cocktail à enregistrer") @RequestBody CocktailDto cocktail) throws ExistingCocktailException;

	/**
	 * Retourne la liste des cocktails contenant l'ingrédient passé dans le body
	 * @param ingredient ingrédient pour filtrer les cocktails
	 * @return la liste des cocktails contenant l'ingrédient passé dans le body
	 * @throws IngredientNotFoundException 
	 */
	@PostMapping("/ingredient")
	@Operation(summary = "Get cocktails filtered by ingredient", description = "Récupère l'ensemble des cocktails contenant l'ingrédient passé en paramètre")
	public List<CocktailDto> getCocktailsWithIngredient(@Parameter(description = "Ingrédient qui doit être contenu dans l'ensemble des cocktails retournés") @RequestBody IngredientDto ingredient)
			throws IngredientNotFoundException;

}
