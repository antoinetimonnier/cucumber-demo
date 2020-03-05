package com.oxxeo.cucumberdemo.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ingredient", uniqueConstraints = @UniqueConstraint(columnNames = { "id", "nom" }))
public class Ingredient {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "nom", nullable = false)
	private String nom;
	
	@Column(name = "quantite", nullable = false)
	private Integer quantite;
	
	@Column(name = "is_alcool", nullable = false)
	private boolean isAlcool;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cocktail")
	private Cocktail cocktail;

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
	
	

}