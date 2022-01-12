package com.tsi.training.aziz.mohammed.Cocktails;

import com.tsi.training.aziz.mohammed.Cocktails.controllers.Glass;
import io.cucumber.java.en.And;
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
public class UpdateGlassStepDef {


    String updatedName;
    int updatedVolume;
    int ID;
    List<Object> correctName = new ArrayList<>();
    List<Object> correctVolume = new ArrayList<>();
    String url = "http://localhost:8080/cocktails/glass/getAll";

    Iterable<Glass> actualGlass;
    List<Integer> glassIDs = new ArrayList<Integer>();

    Response response;

    @Autowired
    main Main;


    @Given("There is a glass to be updated")
    public void thereIsAGlassToBeUpdated() {
        String name = "old name 11";
        //String volumeStr = "300";
        int volume = 300;
        response = RestAssured.get(url);
        Assertions.assertEquals(200, response.getStatusCode());
        correctName = response.jsonPath().getList("name");
        correctVolume = response.jsonPath().getList("volume");
        Assertions.assertFalse(correctName.contains(name));

        //Assertions.assertFalse(correctVolume.contains(volumeStr));

        Main.addAGLass(name, volume);

        response = RestAssured.get(url);
        actualGlass =Main.getAllGlasses();
        for(
                Glass glass:actualGlass)
        {
            glassIDs.add(glass.getIdGlass());
        }
        ID = Collections.max(glassIDs);
        System.out.println(ID);

    }

    @And("I have provided an updates name and volume")
    public void iHaveProvidedAnUpdatesNameAndVolume() {
        updatedName = "new name 7";
        updatedVolume = 500;
    }

    @When("I submit a request to update the glass")
    public void iSubmitARequestToUpdateTheGlass() {
        response = RestAssured.get(url);
        Glass glass = new Glass();
        Main.updatedGlass(glass, ID, updatedName, updatedVolume);
    }

    @Then("The glass should be updated")
    public void theGlassShouldBeUpdated() {
        response = RestAssured.get(url);
        correctName = response.jsonPath().getList("name");
        correctVolume = response.jsonPath().getList("volume");
        Assertions.assertTrue(correctName.contains(updatedName));
        Assertions.assertTrue(correctVolume.contains(updatedVolume));


    // Deleting the created glass

        //Main.deleteGlass(ID);
    }
}
