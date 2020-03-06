package com.oxxeo.cucumberdemo.dao.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
/**
 * Entité représentant un cocktail
 * @author an.timonnier
 *
 */
@Entity
@Table(name = "cocktail", uniqueConstraints = @UniqueConstraint(columnNames = { "id", "nom" }))
public class Cocktail {

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue
	private Long id;
	
	@Column(name = "nom", updatable = false, nullable = false)
	private String nom;
	
	@OneToMany(mappedBy = "cocktail", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Ingredient> ingredients;
	
	@Column(name = "prix", nullable = false)
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

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Long getPrix() {
		return prix;
	}

	public void setPrix(Long prix) {
		this.prix = prix;
	}
	
	
	
}
