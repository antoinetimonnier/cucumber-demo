package com.oxxeo.cucumberdemo.dao.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Entité représentant un cocktail
 * @author an.timonnier
 *
 */
@Entity
@Table(name = "cocktail", uniqueConstraints = @UniqueConstraint(columnNames = { "nom", "prix" }))
public class Cocktail {

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue
	private Integer id;

	@Column(name = "nom", updatable = false, nullable = false)
	private String nom;

	@Column(name = "prix", nullable = false)
	private Long prix;

	@ManyToMany
	@JoinTable(
			name = "cocktail_ingredient",
			joinColumns = @JoinColumn(name = "id_cocktail"),
			inverseJoinColumns = @JoinColumn(name = "id_ingredient"))
	private List<Ingredient> ingredients;

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
