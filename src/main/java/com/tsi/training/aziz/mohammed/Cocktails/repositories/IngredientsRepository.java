package com.tsi.training.aziz.mohammed.Cocktails.repositories;

import com.tsi.training.aziz.mohammed.Cocktails.controllers.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientsRepository extends CrudRepository <Ingredient, Integer> {
}
