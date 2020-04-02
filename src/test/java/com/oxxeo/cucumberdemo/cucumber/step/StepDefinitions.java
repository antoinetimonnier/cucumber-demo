package com.oxxeo.cucumberdemo.cucumber.step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oxxeo.cucumberdemo.cucumber.datatable.CocktailDataTable;
import com.oxxeo.cucumberdemo.dao.repository.CocktailRepository;
import com.oxxeo.cucumberdemo.dao.repository.IngredientRepository;
import com.oxxeo.cucumberdemo.dto.CocktailDto;
import com.oxxeo.cucumberdemo.dto.IngredientDto;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Classe de définition des action word given, when, then 
 * @author an.timonnier
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
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
		cocktail.setIngredients(convertToListOfIngredientDto(ingredients));
		CocktailDto savedCocktail = worldManipulator.appelerPost(worldManipulator.buildUrl("cocktails"), cocktail, CocktailDto.class);
		worldManipulator.getWorld().setSavedCocktail(savedCocktail);
	}

	@Then("^le client doit avoir un retour avec status (\\d+)$")
	public void leClientDoitAvoirUnRetourAvecStatus(int status) throws Throwable {
		Assertions.assertThat(worldManipulator.getWorld().getHttpStatusResponse().get().value()).isEqualTo(status);
	}

	@And("^le client crée un cocktail avec le nom \"([^\"]*)\" et le prix (\\d+)$")
	public void leClientCréeUnCocktailAvecLeNomEtLePrix(String nom, int prix) throws Throwable {
		CocktailDto cocktailDto = new CocktailDto();
		cocktailDto.setNom(nom);
		cocktailDto.setPrix(Long.valueOf(prix));
		CocktailDto savedCocktail = worldManipulator.appelerPost(worldManipulator.buildUrl("cocktails"), cocktailDto, CocktailDto.class);
		worldManipulator.getWorld().setSavedCocktail(savedCocktail);
	}

	@And("^le client doit avoir en retour un cocktail avec le nom = \"([^\"]*)\", le prix =  \"([^\"]*)\" et les ingrédients = \"([^\"]*)\"$")
	public void leClientDoitAvoirEnRetourUnCocktailAvecLeNomLePrixEtLesIngrédients(String nom, String prix, String ingredients) throws Throwable {
		Assertions.assertThat(worldManipulator.getWorld().getSavedCocktail().getNom()).isEqualTo(nom);
		Assertions.assertThat(worldManipulator.getWorld().getSavedCocktail().getPrix()).isEqualTo(Long.valueOf(prix));
		Assertions.assertThat(worldManipulator.getWorld().getSavedCocktail().getIngredients()).containsExactlyElementsOf(convertToListOfIngredientDto(ingredients));
	}

	@And("^Le client ajoute les cocktails suivants :$")
	public void leClientAjouteLesCocktailsSuivants(List<CocktailDataTable> cocktailDataTables) throws Throwable {
		cocktailDataTables.stream().forEach(cocktailDataTable -> {
			CocktailDto cocktailDto = cocktailDataTableToCocktailDto(cocktailDataTable);
			worldManipulator.appelerPost(worldManipulator.buildUrl("cocktails"), cocktailDto, CocktailDto.class);
		});
	}

	@When("^le client récupère lensemble des cocktails avec comme ingrédient \"([^\"]*)\"$")
	public void leClientRécupèreLensembleDesCocktailsAvecCommeIngrédient(String ingredient) throws Throwable {
		IngredientDto ingredientDto = new IngredientDto();
		ingredientDto.setNom(ingredient);
		ingredientDto.setContainsAlcool(true);
		CocktailDto[] arrayOfCocktails = worldManipulator.appelerPost(worldManipulator.buildUrl("cocktails/ingredient"), ingredientDto, CocktailDto[].class);
		if (arrayOfCocktails != null) {
			worldManipulator.getWorld().setReturnedCocktails(Arrays.asList(arrayOfCocktails));
		}
	}

	@And("^le client doit avoir en retour les cocktails suivants :$")
	public void leClientDoitAvoirEnRetourLesCocktailsSuivants(List<CocktailDataTable> cocktailDataTables) throws Throwable {
		Assertions.assertThat(worldManipulator.getWorld().getReturnedCocktails()).containsExactlyElementsOf(cocktailDataTablesToCocktailDtos(cocktailDataTables));
	}

	@When("^le client récupère lensemble des cocktails$")
	public void leClientRécupèreLensembleDesCocktails() throws Throwable {
		CocktailDto[] arrayOfCocktails = worldManipulator.appelerGet(worldManipulator.buildUrl("cocktails"), CocktailDto[].class);
		worldManipulator.getWorld().setReturnedCocktails(Arrays.asList(arrayOfCocktails));
	}

	@And("^la liste de cocktail doit contenir (\\d+) cocktail avec le nom \"([^\"]*)\" et le prix (\\d+)$")
	public void laListeDeCocktailDoitContenirCocktailAvecLeNomEtLePrix(int nombreDeCocktail, String nom, int prix) throws Throwable {
		Assertions.assertThat(worldManipulator.getWorld().getReturnedCocktails()).hasSize(nombreDeCocktail);
		Assertions.assertThat(worldManipulator.getWorld().getReturnedCocktails().get(0).getNom()).isEqualTo(nom);
		Assertions.assertThat(worldManipulator.getWorld().getReturnedCocktails().get(0).getPrix()).isEqualTo(Long.valueOf(prix));
	}

	@And("^le message de lexception doit être \"([^\"]*)\"$")
	public void leMessageDeLExceptionDoitÊtre(String messageException) throws Throwable {
		Assertions.assertThat(worldManipulator.getWorld().getExceptionDto().getMessage()).isEqualTo(messageException);
	}

	@And("^le client doit avoir un retour avec une error \"([^\"]*)\"$")
	public void leClientDoitAvoirUnRetourAvecUneError(String error) throws Throwable {
		Assertions.assertThat(worldManipulator.getWorld().getExceptionDto().getError()).isEqualTo(error);
	}

	/**
	 * Méthode pour convertir un {@link CocktailDataTable} en {@link CocktailDto}
	 * @param cocktailDataTable data table a convertir
	 * @return {@link CocktailDto} converti
	 */
	private CocktailDto cocktailDataTableToCocktailDto(CocktailDataTable cocktailDataTable) {
		CocktailDto cocktailDto = new CocktailDto();
		cocktailDto.setNom(cocktailDataTable.getNom());
		cocktailDto.setPrix(Long.valueOf(cocktailDataTable.getPrix()));
		cocktailDto.setIngredients(convertToListOfIngredientDto(cocktailDataTable.getIngredients()));
		return cocktailDto;
	}

	/**
	 * Méthode pour convertir une liste de {@link CocktailDataTable} en liste de {@link CocktailDto}
	 * @param cocktailDataTables liste de data table a convertir
	 * @return liste de {@link CocktailDto} convertie
	 */
	private List<CocktailDto> cocktailDataTablesToCocktailDtos(List<CocktailDataTable> cocktailDataTables) {
		return cocktailDataTables.stream().map(this::cocktailDataTableToCocktailDto).collect(Collectors.toList());
	}

	/**
	 * Méthode pour convertir un string en liste de {@link IngredientDto}
	 * @param ingredients ingrédients à convertir
	 * @return liste de {@link IngredientDto} convertie
	 * @throws JsonProcessingException
	 * @throws JsonMappingException
	 */
	private List<IngredientDto> convertToListOfIngredientDto(String ingredients) {
		TypeReference<List<IngredientDto>> mapType = new TypeReference<List<IngredientDto>>() {
		};
		List<IngredientDto> ingredientsDto = new ArrayList<IngredientDto>();
		try {
			ingredientsDto = new ObjectMapper().readValue(ingredients.replaceAll("''", "\""), mapType);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return ingredientsDto;
	}
}
