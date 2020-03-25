package com.oxxeo.cucumberdemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.oxxeo.cucumberdemo.dto.CocktailDto;

/**
 * Exception renvoyée lorsque le cocktail passé en paramètre existe déjà en BDD
 * @author an.timonnier
 *
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ExistingCocktailException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7752244304807958630L;

	public ExistingCocktailException(CocktailDto cocktailDto) {
		super("Le cocktail " + cocktailDto.getNom() + " existe déjà");
	}

}
