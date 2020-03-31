package com.oxxeo.cucumberdemo.cucumber.context;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;

import com.oxxeo.cucumberdemo.dto.CocktailDto;

/**
 * La classe world contient tout le contexte de nos scénarios de test (les éléments transverses aux test)
 * @author an.timonnier
 *
 */
public class World {

	private Optional<HttpStatus> httpStatusResponse;
	private ExceptionDto exceptionDto;
	// Cocktail créé (après appel au POST)
	private CocktailDto savedCocktail;
	// Cocktail récupérés (après appel au GET ou au POST /ingredient)
	private List<CocktailDto> returnedCocktails;

	public Optional<HttpStatus> getHttpStatusResponse() {
		return httpStatusResponse;
	}

	public void setHttpStatusResponse(Optional<HttpStatus> httpStatusResponse) {
		this.httpStatusResponse = httpStatusResponse;
	}

	public ExceptionDto getExceptionDto() {
		return exceptionDto;
	}

	public void setExceptionDto(ExceptionDto exceptionDto) {
		this.exceptionDto = exceptionDto;
	}

	public CocktailDto getSavedCocktail() {
		return savedCocktail;
	}

	public void setSavedCocktail(CocktailDto savedCocktail) {
		this.savedCocktail = savedCocktail;
	}

	public List<CocktailDto> getReturnedCocktails() {
		return returnedCocktails;
	}

	public void setReturnedCocktails(List<CocktailDto> returnedCocktails) {
		this.returnedCocktails = returnedCocktails;
	}

}
