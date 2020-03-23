package com.oxxeo.cucumberdemo.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
/**
 * Dto représentant un cocktail
 * @author an.timonnier
 *
 */
public class CocktailDto {
	
	private Integer id;
	
	@NotNull
	private String nom;
	
	@NotEmpty
	private List<IngredientDto> ingredients;
	
	@NotNull
	private Long prix;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<IngredientDto> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientDto> ingredients) {
		this.ingredients = ingredients;
	}

	public Long getPrix() {
		return prix;
	}

	public void setPrix(Long prix) {
		this.prix = prix;
	}
	
	
}
