package com.tsi.training.aziz.mohammed.Cocktails.repositories;

import com.tsi.training.aziz.mohammed.Cocktails.controllers.Cocktail;
import org.springframework.data.repository.CrudRepository;

public interface CocktailsRepository extends CrudRepository <Cocktail, Integer> {
}
