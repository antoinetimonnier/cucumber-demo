package com.oxxeo.cucumberdemo.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oxxeo.cucumberdemo.dao.entity.Cocktail;
/**
 * Repository de l'entité {@link Cocktail}
 * @author an.timonnier
 *
 */
public interface ICocktailRepository extends JpaRepository<Cocktail, Long>{

}
