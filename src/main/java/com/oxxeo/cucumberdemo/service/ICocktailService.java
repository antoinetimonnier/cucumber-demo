package com.oxxeo.cucumberdemo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oxxeo.cucumberdemo.dto.CocktailDto;

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
	public List<CocktailDto> getCocktails();
	
	/**
	 * Méthode d'enregistrement d'un cocktail
	 * @param cocktail cocktail à créer
	 * @return le cocktail créé
	 */
	@PostMapping
	public ResponseEntity<CocktailDto> saveCocktail(@RequestBody CocktailDto cocktail);
	
}
