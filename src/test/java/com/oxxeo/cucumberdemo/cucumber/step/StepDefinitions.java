package com.oxxeo.cucumberdemo.cucumber.step;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oxxeo.cucumberdemo.dao.repository.CocktailRepository;
import com.oxxeo.cucumberdemo.dao.repository.IngredientRepository;
import com.oxxeo.cucumberdemo.dto.CocktailDto;
import com.oxxeo.cucumberdemo.dto.IngredientDto;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Classe de définition des given, when, then pour ce qui se rapporte directement à l'api
 * @author an.timonnier
 *
 */
public class StepDefinitions {
	
	@Autowired
	private WorldManipulator worldManipulator;
	
	@Autowired
	private CocktailRepository cocktailRepository;
	
	@Autowired
	private IngredientRepository ingredientRepository;
	
	@Given("la base de donnée est vide")
	public void laBaseDeDonneeEstVide() {
		ingredientRepository.deleteAll();
		cocktailRepository.deleteAll();
	}
	

	@When("^Le client ajoute un cocktail avec le nom = \"([^\"]*)\", le prix = \"([^\"]*)\", les ingrédients = \"([^\"]*)\"$")
	public void leClientAjouteUnCocktailAvecLeNomLePrixLesIngrédients(String nom, String prix, String ingredients)
			throws Throwable {
		CocktailDto cocktail = new CocktailDto();
		cocktail.setNom(nom);
		cocktail.setPrix(Long.valueOf(prix));
		TypeReference<List<IngredientDto>> mapType = new TypeReference<List<IngredientDto>>() {};
		List<IngredientDto> ingredientsDto = new ObjectMapper().readValue(ingredients.replaceAll("''", "\""), mapType);
		cocktail.setIngredients(ingredientsDto);
		worldManipulator.appelerPost(worldManipulator.buildUrl("cocktails"), cocktail, CocktailDto.class);
	}



	@Then("^le client doit avoir un retour avec status (\\d+)$")
	public void leClientDoitAvoirUnRetourAvecStatus(int status) throws Throwable {
		Assertions.assertThat(worldManipulator.getWorld().getHttpStatusResponse().get().value()).isEqualTo(status);
	}




	
	

}

