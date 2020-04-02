package com.oxxeo.cucumberdemo.cucumber.datatable;

import com.oxxeo.cucumberdemo.dto.CocktailDto;

/**
 * Datatable contenant représentant un {@link CocktailDto}
 * @author an.timonnier
 *
 */
public class CocktailDataTable {

	private String nom;

	private String prix;

	private String ingredients;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

}
