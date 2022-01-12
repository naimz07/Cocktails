package com.tsi.training.aziz.mohammed.Cocktails;


import com.tsi.training.aziz.mohammed.Cocktails.controllers.Glass;
import com.tsi.training.aziz.mohammed.Cocktails.repositories.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

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

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        Main = new main(
                glassRepository, garnishRepository, ingredientsRepository, equipmentRepository, cocktailsRepository);
    }

    @org.testng.annotations.Test
    public void testGetGlasses() {
        Main.getAllGlasses();
        verify(glassRepository).findAll();
    }

    @org.testng.annotations.Test
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


    @org.testng.annotations.Test
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
    @org.testng.annotations.Test
    public void testUpdateGlass() {
        Glass glass = new Glass();
        int idglass = 0;
        String name = "test glass";
        int volume = 500;
        String actualReturn = Main.updatedGlass(glass, idglass, name, volume);
        String expectedReturn = "Glass Updated";
        Assertions.assertEquals(expectedReturn, actualReturn);
        ArgumentCaptor<Glass> glassArgumentCaptor = ArgumentCaptor.forClass(Glass.class);
        verify(glassRepository).save(glassArgumentCaptor.capture());


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

//    @Test
//    void testDeleteGlassNotFound(){
//        Exception exception = Assertions.assertThrows(Exception.class, () -> {
//            glassService.deleteGlass(anyInt());
//        });
//        String expected = "No glass could be found with the given ID";
//        String actual = exception.getMessage();
//        Assertions.assertEquals(expected, actual);
//    }
//
////}