package com.oxxeo.cucumberdemo.dao.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Entité représentant un ingrédient
 * @author an.timonnier
 *
 */
@Entity
@Table(name = "ingredient", uniqueConstraints = @UniqueConstraint(columnNames = { "nom", "contains_alcool" }))
public class Ingredient {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nom", nullable = false)
	private String nom;

	@Column(name = "contains_alcool", nullable = false)
	private boolean containsAlcool;

	@ManyToMany(mappedBy = "ingredients")
	private List<Cocktail> cocktails;

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

	public List<Cocktail> getCocktails() {
		return cocktails;
	}

	public void setCocktails(List<Cocktail> cocktails) {
		this.cocktails = cocktails;
	}

}
