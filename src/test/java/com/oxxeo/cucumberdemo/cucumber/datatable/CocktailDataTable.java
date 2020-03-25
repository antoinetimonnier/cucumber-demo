package com.oxxeo.cucumberdemo.cucumber.datatable;

import com.oxxeo.cucumberdemo.dto.CocktailDto;

/**
 * Datatable contenant représentant un {@link CocktailDto}
 * @author an.timonnier
 *
 */
public class CocktailDataTable {

	private String nom;

	private Long prix;

	private String ingredients;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getPrix() {
		return prix;
	}

	public void setPrix(Long prix) {
		this.prix = prix;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

}
