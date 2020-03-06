package com.oxxeo.cucumberdemo.dto;

/**
 * DTO représentant un ingrédient
 * @author an.timonnier
 *
 */
public class IngredientDto {

	private Long id;
	
	private String nom;
	
	private Integer quantite;
	
	private boolean isAlcool;
	
	private Long idCocktail;

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

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public boolean isAlcool() {
		return isAlcool;
	}

	public void setAlcool(boolean isAlcool) {
		this.isAlcool = isAlcool;
	}

	public Long getIdCocktail() {
		return idCocktail;
	}

	public void setIdCocktail(Long idCocktail) {
		this.idCocktail = idCocktail;
	}
	
	
}
