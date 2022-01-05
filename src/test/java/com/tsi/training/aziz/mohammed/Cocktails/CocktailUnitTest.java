package com.tsi.training.aziz.mohammed.Cocktails;

import com.tsi.training.aziz.mohammed.Cocktails.controllers.Cocktail;
import com.tsi.training.aziz.mohammed.Cocktails.repositories.*;
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
public class CocktailUnitTest {

    @Mock
    private GlassRepository glassRepository;
    @Mock
    private GarnishRepository garnishRepository;
    @Mock
    private IngredientsRepository ingredientsRepository;
    @Mock
    private EquipmentRepository equipmentRepository;
    @Mock
    private CocktailsRepository cocktailsRepository;

    private main Main;

    @BeforeEach
    void setUp() {
        Main = new main(glassRepository, garnishRepository, ingredientsRepository, equipmentRepository, cocktailsRepository);
    }
    @Test
    public void testGetAllCocktails() {
        Main.getAllCocktails();
        verify(cocktailsRepository).findAll();
    }

    @Test
    public void testGetCocktail() {
        Cocktail cocktail = new Cocktail();
        cocktail.setName("Mojito");
        cocktail.setDescription("Bubbly and nice");
        cocktail.setPrice(7);

        // Setting conditions of the test
        given(cocktailsRepository.findById(cocktail.getIdcocktail())).willReturn(Optional.of(cocktail));

        // Setting the expected value
        Cocktail expected = Main.getCocktail(cocktail.getIdcocktail()).get();

        // Asserting the two values are equal
        Assertions.assertEquals(expected, cocktail);

        // Verifying that the findById method was called
        verify(cocktailsRepository, atLeastOnce()).findById(cocktail.getIdcocktail());
    }


    @Test
    public void testAddCocktail() {
        // Creating test object
        Cocktail cocktail = new Cocktail();
        cocktail.setName("Mojito");
        cocktail.setDescription("Bubbly and nice");
        cocktail.setPrice(7);

        // Setting the expected return string
        String expected = "New Cocktail Saved";

        // Adding object to the repo and capturing return value
        String actual = Main.addCocktail(cocktail.getName(), cocktail.getDescription(), cocktail.getPrice());

        // Creating an argument captor
        ArgumentCaptor<Cocktail> cocktailArgumentCaptor = ArgumentCaptor.forClass(Cocktail.class);

        // Verifying that save() was called on the repo
        verify(cocktailsRepository).save(cocktailArgumentCaptor.capture());

        // Getting the captured value
        Cocktail capturedCocktail = cocktailArgumentCaptor.getValue();

        // Asserting the captured value is the same as the original object
        Assertions.assertEquals(cocktail.toString(), capturedCocktail.toString());
        Assertions.assertEquals(expected, actual);

    }
    //
    @Test
    public void testUpdateCocktail() {
        Cocktail cocktail = new Cocktail();

        // Defining the method call in the updateGlass method and its return type
        //given(glassRepository.findById(glass.getIdGlass())).willReturn(Optional.of(glass));

        // Adding glass to repo
        Main.addCocktail(cocktail.getName(), cocktail.getDescription(), cocktail.getPrice());

        // Updating the type of the glass
        cocktail.setName("Updated");

        // Creating argument captor
        ArgumentCaptor<Cocktail> cocktailArgumentCaptor = ArgumentCaptor.forClass(Cocktail.class);

        // Capturing the actual and expected results
        String actual = Main.updatedCocktail(cocktail);
        String expected = "Cocktail Updated";

        // Verifying if the save method has been called at least twice (initial save then update)
        verify(cocktailsRepository, atLeast(2)).save(cocktailArgumentCaptor.capture());

        Cocktail capturedCocktail = cocktailArgumentCaptor.getValue();

        // Verifying if findById has been called once
        //verify(glassRepository, atLeast(1)).findById(glass.getIdGlass());


        // Asserting the values are as expected
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(cocktail, capturedCocktail);

    }

    @Test
    public void testDeleteCocktail(){
        Cocktail cocktail = new Cocktail();

        // Defining what the findById method will use and what will be returned
        //given(glassRepository.findById(glass.getIdGlass())).willReturn(Optional.of(glass));

        // Setting actual vs expected results
        String expected = "Cocktail Deleted";
        String actual = Main.deleteCocktail(cocktail.getIdcocktail());

        // Asserting the returned strings are equal and that deleteById has been called on the repo
        Assertions.assertEquals(expected, actual);
        verify(cocktailsRepository).deleteById(cocktail.getIdcocktail());}

}
