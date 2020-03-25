package com.oxxeo.cucumberdemo.dto;

import javax.validation.constraints.NotNull;

/**
 * DTO représentant un ingrédient
 * @author an.timonnier
 *
 */
public class IngredientDto {

	private Integer id;

	@NotNull
	private String nom;

	private boolean containsAlcool;

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

	public boolean isContainsAlcool() {
		return containsAlcool;
	}

	public void setContainsAlcool(boolean containsAlcool) {
		this.containsAlcool = containsAlcool;
	}

}
