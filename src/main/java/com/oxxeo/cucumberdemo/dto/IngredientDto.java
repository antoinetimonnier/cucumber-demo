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

	@NotNull
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (containsAlcool ? 1231 : 1237);
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IngredientDto other = (IngredientDto) obj;
		if (containsAlcool != other.containsAlcool)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

}
