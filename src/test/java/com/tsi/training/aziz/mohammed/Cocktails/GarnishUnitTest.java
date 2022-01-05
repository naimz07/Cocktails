package com.tsi.training.aziz.mohammed.Cocktails;

import com.tsi.training.aziz.mohammed.Cocktails.controllers.Garnish;
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
public class GarnishUnitTest {



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
    public void testGetGarnishes() {
        Main.getAllGarnishes();
        verify(garnishRepository).findAll();
    }

    @Test
    public void testGetGarnish() {
        Garnish garnish = new Garnish();
        garnish.setName("Umbrella");
        garnish.setFood(false);

        // Setting conditions of the test
        given(garnishRepository.findById(garnish.getIdGarnish())).willReturn(Optional.of(garnish));

        // Setting the expected value
        Garnish expected = Main.getGarnish(garnish.getIdGarnish()).get();

        // Asserting the two values are equal
        Assertions.assertEquals(expected, garnish);

        // Verifying that the findById method was called
        verify(garnishRepository, atLeastOnce()).findById(garnish.getIdGarnish());
    }


    @Test
    public void testAddGarnish() {
        // Creating test object
        Garnish savedGarnish = new Garnish();
        savedGarnish.setName("Umbrella");
        savedGarnish.setFood(false);

        // Setting the expected return string
        String expected = "New Garnish Saved";

        // Adding object to the repo and capturing return value
        String actual = Main.addAGarnish(savedGarnish.getName(), savedGarnish.getFood());

        // Creating an argument captor
        ArgumentCaptor<Garnish> garnishArgumentCaptor = ArgumentCaptor.forClass(Garnish.class);

        // Verifying that save() was called on the repo
        verify(garnishRepository).save(garnishArgumentCaptor.capture());

        // Getting the captured value
        Garnish capturedGarnish = garnishArgumentCaptor.getValue();

        // Asserting the captured value is the same as the original object
        Assertions.assertEquals(savedGarnish.toString(), capturedGarnish.toString());
        Assertions.assertEquals(expected, actual);

    }
    //
    @Test
    public void testUpdateGarnish() {
        Garnish garnish = new Garnish();

        // Defining the method call in the updateGlass method and its return type
        //given(glassRepository.findById(glass.getIdGlass())).willReturn(Optional.of(glass));

        // Adding glass to repo
        Main.addAGarnish(garnish.getName(), garnish.getFood());

        // Updating the type of the glass
        garnish.setName("Updated");

        // Creating argument captor
        ArgumentCaptor<Garnish> garnishArgumentCaptor = ArgumentCaptor.forClass(Garnish.class);

        // Capturing the actual and expected results
        String actual = Main.updatedGarnish(garnish);
        String expected = "Garnish Updated";

        // Verifying if the save method has been called at least twice (initial save then update)
        verify(garnishRepository, atLeast(2)).save(garnishArgumentCaptor.capture());

        Garnish capturedGarnish = garnishArgumentCaptor.getValue();

        // Verifying if findById has been called once
        //verify(glassRepository, atLeast(1)).findById(glass.getIdGlass());


        // Asserting the values are as expected
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(garnish, capturedGarnish);

    }

    @Test
    public void testDeleteGarnish(){
        Garnish garnish = new Garnish();

        // Defining what the findById method will use and what will be returned
        //given(glassRepository.findById(glass.getIdGlass())).willReturn(Optional.of(glass));

        // Setting actual vs expected results
        String expected = "Garnish Deleted";
        String actual = Main.deleteGarnish(garnish.getIdGarnish());

        // Asserting the returned strings are equal and that deleteById has been called on the repo
        Assertions.assertEquals(expected, actual);
        verify(garnishRepository).deleteById(garnish.getIdGarnish());}}
