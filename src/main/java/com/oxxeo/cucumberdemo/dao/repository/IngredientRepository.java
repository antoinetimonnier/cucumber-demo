package com.oxxeo.cucumberdemo.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oxxeo.cucumberdemo.dao.entity.Ingredient;

/**
 * Repository des objets {@link Ingredient}
 * @author an.timonnier
 *
 */
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

	/**
	 * Méthode pour récupérer un ingrédient via son nom et le boolean containsAlcool
	 * @param nom nom du cocktail
	 * @param containsAlcool boolean indiquant si l'ingredient contient de l'alcool
	 * @return l'ingredient correspondant
	 */
	Ingredient findByNomAndContainsAlcool(String nom, boolean containsAlcool);

}
