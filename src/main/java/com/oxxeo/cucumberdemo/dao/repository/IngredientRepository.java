package com.oxxeo.cucumberdemo.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oxxeo.cucumberdemo.dao.entity.Ingredient;

/**
 * Repository des objets {@link Ingredient}
 * @author an.timonnier
 *
 */
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

	Ingredient findByNomAndContainsAlcool(String nom, boolean containsAlcool);

}
