package com.oxxeo.cucumberdemo.dto;

import java.util.List;

public class CocktailDto {
	
	private Long id;
	
	private String nom;
	
	private List<IngredientDto> ingredients;
	
	private Long prix;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
