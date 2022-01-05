package com.tsi.training.aziz.mohammed.Cocktails;

import com.tsi.training.aziz.mohammed.Cocktails.controllers.Ingredient;
import com.tsi.training.aziz.mohammed.Cocktails.repositories.EquipmentRepository;
import com.tsi.training.aziz.mohammed.Cocktails.repositories.GarnishRepository;
import com.tsi.training.aziz.mohammed.Cocktails.repositories.GlassRepository;
import com.tsi.training.aziz.mohammed.Cocktails.repositories.IngredientsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IngredientsUnitTest {


    @Mock
    private GlassRepository glassRepository;
    @Mock
    private GarnishRepository garnishRepository;
    @Mock
    private IngredientsRepository ingredientsRepository;
    @Mock
    private EquipmentRepository equipmentRepository;

    private main Main;

    @BeforeEach
    void setUp() {
        Main = new main(glassRepository, garnishRepository, ingredientsRepository, equipmentRepository);
    }

    @Test
    public void testGetGlasses() {
        Main.getAllGlasses();
        verify(glassRepository).findAll();
    }

    @Test
    public void testGetIngredients() {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("Ice");
        ingredient.setAlcLevel(0);
        ingredient.setDescription("Frozen Water");

        // Setting conditions of the test
        given(ingredientsRepository.findById(ingredient.getIdingredient())).willReturn(Optional.of(ingredient));

        // Setting the expected value
        Ingredient expected = Main.getIngredients(ingredient.getIdingredient()).get();

        // Asserting the two values are equal
        Assertions.assertEquals(expected, ingredient);

        // Verifying that the findById method was called
        verify(ingredientsRepository, atLeastOnce()).findById(ingredient.getIdingredient());
    }


    @Test
    public void testAddIngredient() {
        // Creating test object
        Ingredient ingredient = new Ingredient();
        ingredient.setName("Ice");
        ingredient.setAlcLevel(0);
        ingredient.setDescription("Frozen Water");

        // Setting the expected return string
        String expected = "New Ingredient Saved";

        // Adding object to the repo and capturing return value
        String actual = Main.addAIngredient(ingredient.getName(), ingredient.getAlcLevel(), ingredient.getDescription());

        // Creating an argument captor
        ArgumentCaptor<Ingredient> ingredientArgumentCaptor = ArgumentCaptor.forClass(Ingredient.class);

        // Verifying that save() was called on the repo
        verify(ingredientsRepository).save(ingredientArgumentCaptor.capture());

        // Getting the captured value
        Ingredient capturedIngredient = ingredientArgumentCaptor.getValue();

        // Asserting the captured value is the same as the original object
        Assertions.assertEquals(ingredient.toString(), capturedIngredient.toString());
        Assertions.assertEquals(expected, actual);

    }
    //
    @Test
    public void testUpdateIngredient() {
        Ingredient ingredient = new Ingredient();

        // Defining the method call in the updateGlass method and its return type
        //given(glassRepository.findById(glass.getIdGlass())).willReturn(Optional.of(glass));

        // Adding glass to repo
        Main.addAIngredient(ingredient.getName(), ingredient.getAlcLevel(), ingredient.getDescription());

        // Updating the type of the glass
        ingredient.setName("Updated");

        // Creating argument captor
        ArgumentCaptor<Ingredient> ingredientArgumentCaptor = ArgumentCaptor.forClass(Ingredient.class);

        // Capturing the actual and expected results
        String actual = Main.updatedIngredient(ingredient);
        String expected = "Ingredient Updated";

        // Verifying if the save method has been called at least twice (initial save then update)
        verify(ingredientsRepository, atLeast(2)).save(ingredientArgumentCaptor.capture());

        Ingredient capturedIngredient = ingredientArgumentCaptor.getValue();

        // Verifying if findById has been called once
        //verify(glassRepository, atLeast(1)).findById(glass.getIdGlass());


        // Asserting the values are as expected
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(ingredient, capturedIngredient);

    }

    @Test
    public void testDeleteIngredient(){
        Ingredient ingredient = new Ingredient();

        // Defining what the findById method will use and what will be returned
        //given(glassRepository.findById(glass.getIdGlass())).willReturn(Optional.of(glass));

        // Setting actual vs expected results
        String expected = "Ingredient Deleted";
        String actual = Main.deleteIngredients(ingredient.getIdingredient());

        // Asserting the returned strings are equal and that deleteById has been called on the repo
        Assertions.assertEquals(expected, actual);
        verify(ingredientsRepository).deleteById(ingredient.getIdingredient());
    }

}
