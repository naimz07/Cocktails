package com.tsi.training.aziz.mohammed.Cocktails;


import com.tsi.training.aziz.mohammed.Cocktails.controllers.Glass;
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
public class GlassUnitTest {

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
    public void testGetGlasses() {
        Main.getAllGlasses();
        verify(glassRepository).findAll();
    }

    @Test
    public void testGetGlass() {
        Glass glass = new Glass();
        glass.setName("MARTINI");
        glass.setVolume(300);

        // Setting conditions of the test
        given(glassRepository.findById(glass.getIdGlass())).willReturn(Optional.of(glass));

        // Setting the expected value
        Glass expected = Main.getGlass(glass.getIdGlass()).get();

        // Asserting the two values are equal
        Assertions.assertEquals(expected, glass);

        // Verifying that the findById method was called
        verify(glassRepository, atLeastOnce()).findById(glass.getIdGlass());
    }


    @Test
    public void testAddGlass() {
        // Creating test object
        Glass savedGlass = new Glass();
        savedGlass.setName("MARTINI");
        savedGlass.setVolume(300);

        // Setting the expected return string
        String expected = "New Glass Saved";

        // Adding object to the repo and capturing return value
        String actual = Main.addAGLass(savedGlass.getName(), savedGlass.getVolume());

        // Creating an argument captor
        ArgumentCaptor<Glass> glassArgumentCaptor = ArgumentCaptor.forClass(Glass.class);

        // Verifying that save() was called on the repo
        verify(glassRepository).save(glassArgumentCaptor.capture());

        // Getting the captured value
        Glass capturedGlass = glassArgumentCaptor.getValue();

        // Asserting the captured value is the same as the original object
        Assertions.assertEquals(savedGlass.toString(), capturedGlass.toString());
        Assertions.assertEquals(expected, actual);

    }
//
    @Test
    public void testUpdateGlass() {
        Glass glass = new Glass();

        // Defining the method call in the updateGlass method and its return type
        //given(glassRepository.findById(glass.getIdGlass())).willReturn(Optional.of(glass));

        // Adding glass to repo
        Main.addAGLass(glass.getName(), glass.getVolume());

        // Updating the type of the glass
        glass.setName("Updated");

        // Creating argument captor
        ArgumentCaptor<Glass> glassArgumentCaptor = ArgumentCaptor.forClass(Glass.class);

        // Capturing the actual and expected results
        String actual = Main.updatedGlass(glass);
        String expected = "Glass Updated";

        // Verifying if the save method has been called at least twice (initial save then update)
        verify(glassRepository, atLeast(2)).save(glassArgumentCaptor.capture());

        Glass capturedGlass = glassArgumentCaptor.getValue();

        // Verifying if findById has been called once
        //verify(glassRepository, atLeast(1)).findById(glass.getIdGlass());


        // Asserting the values are as expected
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(glass, capturedGlass);

    }

 @Test
    public void testDeleteGlass(){
        Glass glass = new Glass();

        // Defining what the findById method will use and what will be returned
       //given(glassRepository.findById(glass.getIdGlass())).willReturn(Optional.of(glass));

        // Setting actual vs expected results
        String expected = "Glass Deleted";
        String actual = Main.deleteGlass(glass.getIdGlass());

        // Asserting the returned strings are equal and that deleteById has been called on the repo
        Assertions.assertEquals(expected, actual);
        verify(glassRepository).deleteById(glass.getIdGlass());
    }}
//
////}