package com.oxxeo.cucumberdemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.oxxeo.cucumberdemo.dto.IngredientDto;

/**
 * Exception renvoyée lorsque l'ingrédient passé en paramètre n'existe pas en BDD
 * @author an.timonnier
 *
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IngredientNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4064307705779926941L;

	public IngredientNotFoundException(IngredientDto ingredientDto) {
		super("L'ingrédient " + ingredientDto.getNom() + " n'existe pas");
	}
}
