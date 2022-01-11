package com.tsi.training.aziz.mohammed.Cocktails;

import com.tsi.training.aziz.mohammed.Cocktails.controllers.Glass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GetAllGlassStepDef {

    @Autowired
    main Main;

    Response response;
    Iterable<Glass> actualGetAll;
    String url = "http://localhost:8080/cocktails/glass/getAll";


    @Given("I have access to the database")
    public void iHaveAccessToTheDatabase() {
        response = RestAssured.get(url);
        Assertions.assertEquals(200, response.getStatusCode());

    }

    @When("I submit a request for all the glasses")
    public void iSubmitARequestForAllTheGlasses() {
        actualGetAll = Main.getAllGlasses();
    }

    @Then("I should receive all the glasses in the database")
    public void iShouldReceiveAllTheGlassesInTheDatabase() {
        List<Object> correctGlassIDs = response.jsonPath().getList("idGlass");
        List<Object> correctGlassName = response.jsonPath().getList("name");
        List<Object> correctGlassVol = response.jsonPath().getList("volume");

        List<Object> actualGlassIDs = new ArrayList<Object>();
        List<Object> actualGlassName = new ArrayList<Object>();
        List<Object> actualGlassVol = new ArrayList<Object>();
        for (Glass glass: actualGetAll) {
            actualGlassIDs.add(glass.getIdGlass());
            actualGlassName.add(glass.getName());
            actualGlassVol.add(glass.getVolume());
        }
        Assertions.assertEquals(correctGlassIDs, actualGlassIDs);
        Assertions.assertEquals(correctGlassName, actualGlassName);
        Assertions.assertEquals(correctGlassVol, actualGlassVol);


    }
}
