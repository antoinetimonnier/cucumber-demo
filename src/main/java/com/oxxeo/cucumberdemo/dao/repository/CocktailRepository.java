package com.oxxeo.cucumberdemo.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oxxeo.cucumberdemo.dao.entity.Cocktail;

public interface CocktailRepository extends JpaRepository<Cocktail, Integer>{

}
