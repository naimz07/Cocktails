package com.tsi.training.aziz.mohammed.Cocktails;

import com.tsi.training.aziz.mohammed.Cocktails.controllers.Equipment;
import com.tsi.training.aziz.mohammed.Cocktails.repositories.EquipmentRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AddAEquipmentStepDef {

    @Autowired
    EquipmentRepository equipmentRepository;
    @Autowired
    main Main;


    String name;
    boolean needsPower;

    Iterable<Equipment> actualEquipment;
    List<Integer> equipmentIDs = new ArrayList<Integer>();
    Response response;
    //JsonPath json;



    @Given("I have added a name for the equipment")
    public void i_have_added_a_name_for_the_equipment(){
        name = "Test12345";
    }

    @Given("I have stated if the equipment needs power or not")
    public void i_have_stated_if_the_equipment_needs_power_or_not(){
        needsPower = true;
    }

    @When("I submit a request to add the equipment")
    public void i_submit_a_request_to_add_the_equipment(){

        String url = "http://localhost:8080/cocktails/equipment/getAll";
        response = RestAssured.get(url);
        Assertions.assertEquals(200, response.getStatusCode());
        Main.addEquipment(name, needsPower);
    }

    @Then("The equipment is saved to the database")
    public void the_equipment_is_saved_to_the_database(){

        String returnedString = response.getBody().asString();
        Assertions.assertTrue(returnedString.contains(name));
        // Assertions.assertEquals(glass.getVolume(), returnString);

        // Deleting the created glass
        actualEquipment = Main.getAllEquipment();
        for (Equipment equipment: actualEquipment){
            equipmentIDs.add(equipment.getIdequipment());
        }
        int testEquipmentID = Collections.max(equipmentIDs);
        Main.deleteEquipment(testEquipmentID);
    }
}
