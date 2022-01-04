package com.tsi.training.aziz.mohammed.Cocktails;


import com.tsi.training.aziz.mohammed.Cocktails.repositories.GlassRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class GlassUnitTest {

    @Mock
    private GlassRepository glassRepository;

    private main Main;

    @BeforeEach
    void setUp() {
        Main = new main(glassRepository);
    }

    @Test
    public void testGetGlasses() {
        Main.getAllGlasses();
        verify(glassRepository).findAll();
    }}

//    @Test
//    public void testGetGlass() {
//        Glass glass = new Glass();
//        glass.setName("");
//        glass.setVolume(568);
//
//        // Setting conditions of the test
//        given(glassRepository.findById(glass.getIdGlass())).willReturn(Optional.of(glass));
//
//        // Setting the expected value
//        Optional<Glass> expected = main.getGlass(glass.getIdGlass());
//
//        // Asserting the two values are equal
//        Assertions.assertEquals(expected, glass);
//
//        // Verifying that the findById method was called
//        verify(glassRepository, atLeastOnce()).findById(glass.getIdGlass());
//    }
//
//    @Test
//    public void testGetGlassNotFound() {
//        Exception exception = Assertions.assertThrows(Exception.class, () -> {
//            main.getGlass(anyInt());
//        });
//        String expected = "No glass could be found with the given ID";
//        String actual = exception.getMessage();
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testAddGlass() {
//        // Creating test object
//        Glass glass = new Glass();
//        glass.setName("Pint");
//        glass.setVolume(568);
//
//        // Setting the expected return string
//        String expected = "New Glass Saved";
//
//        // Adding object to the repo and capturing return value
//        String actual = main.addAGLass(glass.getName(), glass.getVolume());
//
//        // Creating an argument captor
//        ArgumentCaptor<Glass> glassArgumentCaptor = ArgumentCaptor.forClass(Glass.class);
//
//        // Verifying that save() was called on the repo
//        verify(glassRepository).save(glassArgumentCaptor.capture());
//
//        // Getting the captured value
//        Glass capturedGlass = glassArgumentCaptor.getValue();
//
//        // Asserting the captured value is the same as the original object
//        Assertions.assertEquals(glass, capturedGlass);
//        Assertions.assertEquals(expected, actual);
//
//    }
//
//    @Test
//    public void testUpdateGlass() {
//        Glass glass = new Glass();
//
//        // Defining the method call in the updateGlass method and its return type
//        given(glassRepository.findById(glass.getIdGlass())).willReturn(Optional.of(glass));
//
//        // Adding glass to repo
//        main.addAGLass(glass.getName(), glass.getVolume());
//
//        // Updating the type of the glass
//        glass.setName("Updated");
//
//        // Creating argument captor
//        ArgumentCaptor<Glass> glassArgumentCaptor = ArgumentCaptor.forClass(Glass.class);
//
//        // Capturing the actual and expected results
//        String actual = main.updatedGlass(glass);
//        String expected = "Glass Updated";
//
//        // Verifying if the save method has been called at least twice (initial save then update)
//        verify(glassRepository).save(glassArgumentCaptor.capture());
//        Glass capturedGlass = glassArgumentCaptor.getValue();
//
//        // Verifying if findById has been called once
//        verify(glassRepository).findById(glass.getIdGlass());
//
//        // Asserting the values are as expected
//        Assertions.assertEquals(expected, actual);
//        Assertions.assertEquals(glass, capturedGlass);
//
//    }}
//
////    @Test
////    public void testUpdatedGlassNotFound() {
////        Exception exception = Assertions.assertThrows(Exception.class, () -> {
////            main.updateGlass(new Glass());
////        });
////        String expected = "No glass could be found with the given ID";
////        String actual = exception.getMessage();
////        Assertions.assertEquals(expected, actual);
////    }
//
//    // finish the tests for here ie DELETE
//
////}