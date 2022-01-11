package com.tsi.training.aziz.mohammed.Cocktails;

import com.tsi.training.aziz.mohammed.Cocktails.controllers.Equipment;
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
public class EquipmentUnitTest {



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
    public void testGetAllEquipment(){
        Main.getAllEquipment();
        verify(equipmentRepository).findAll();
    }

    @Test
    public void testGetEquipment() {
        Equipment equipment = new Equipment();
        equipment.setName("Blender");
        equipment.setNeedsPower(true);

        // Setting conditions of the test
        given(equipmentRepository.findById(equipment.getIdequipment())).willReturn(Optional.of(equipment));

        // Setting the expected value
        Equipment expected = Main.getEquipment(equipment.getIdequipment()).get();

        // Asserting the two values are equal
        Assertions.assertEquals(expected, equipment);

        // Verifying that the findById method was called
        verify(equipmentRepository, atLeastOnce()).findById(equipment.getIdequipment());
    }


    @Test
    public void testAddEquipment() {
        // Creating test object
        Equipment equipment = new Equipment();
        equipment.setName("Blender");
        equipment.setNeedsPower(true);

        // Setting the expected return string
        String expected = "New Equipment Saved";

        // Adding object to the repo and capturing return value
        String actual = Main.addEquipment(equipment.getName(), equipment.getNeedsPower());

        // Creating an argument captor
        ArgumentCaptor<Equipment> equipmentArgumentCaptor = ArgumentCaptor.forClass(Equipment.class);

        // Verifying that save() was called on the repo
        verify(equipmentRepository).save(equipmentArgumentCaptor.capture());

        // Getting the captured value
        Equipment capturedEquipment = equipmentArgumentCaptor.getValue();

        // Asserting the captured value is the same as the original object
        Assertions.assertEquals(equipment.toString(), capturedEquipment.toString());
        Assertions.assertEquals(expected, actual);

    }
    //
    @Test
    public void testUpdateEquipment() {
        Equipment equipment = new Equipment();
        // Defining the method call in the updateGlass method and its return type
        //given(glassRepository.findById(glass.getIdGlass())).willReturn(Optional.of(glass));

        // Adding glass to repo
        Main.addEquipment(equipment.getName(), equipment.getNeedsPower());

        // Updating the type of the glass
        equipment.setName("Updated");

        // Creating argument captor
        ArgumentCaptor<Equipment> equipmentArgumentCaptor = ArgumentCaptor.forClass(Equipment.class);

        // Capturing the actual and expected results
        String actual = Main.updatedEquipment(equipment);
        String expected = "Equipment Updated";

        // Verifying if the save method has been called at least twice (initial save then update)
        verify(equipmentRepository, atLeast(2)).save(equipmentArgumentCaptor.capture());

        Equipment capturedEquipment = equipmentArgumentCaptor.getValue();

        // Verifying if findById has been called once
        //verify(glassRepository, atLeast(1)).findById(glass.getIdGlass());


        // Asserting the values are as expected
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(equipment, capturedEquipment);

    }

    @Test
    public void testDeleteEquipment(){
        Equipment equipment = new Equipment();

        // Defining what the findById method will use and what will be returned
        //given(glassRepository.findById(glass.getIdGlass())).willReturn(Optional.of(glass));

        // Setting actual vs expected results
        String expected = "Equipment Deleted";
        String actual = Main.deleteEquipment(equipment.getIdequipment());

        // Asserting the returned strings are equal and that deleteById has been called on the repo
        Assertions.assertEquals(expected, actual);
        verify(equipmentRepository).deleteById(equipment.getIdequipment());
    }
}
