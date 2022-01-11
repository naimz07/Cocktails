package com.tsi.training.aziz.mohammed.Cocktails;

import com.tsi.training.aziz.mohammed.Cocktails.controllers.Garnish;
import com.tsi.training.aziz.mohammed.Cocktails.repositories.GarnishRepository;
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
public class DeleteAGarnishStepDef {

    @Autowired
    GarnishRepository garnishRepository;
    @Autowired
    main Main;

    String name = "test12345";
    boolean food = true;
    Iterable<Garnish> deleteGarnish;
    String url = "http://localhost:8080/cocktails/glass/getAll";
    List<Integer> garnishIDs = new ArrayList<Integer>();
    Response response;


    @Given("There is a garnish in the database to be deleted")
    public void there_is_a_garnish_in_the_database_to_be_deleted() {
        Main.addAGarnish(name, food);
    }

    @And("I have provided the garnish ID")
    public void i_have_provided_the_garnish_id() {
        deleteGarnish = Main.getAllGarnishes();
        for (Garnish garnish: deleteGarnish) {
            garnishIDs.add(garnish.getIdGarnish());
        }
    }

    @When("I submit a request to delete the garnish")
    public void i_submit_a_request_to_delete_the_garnish() {
        response = RestAssured.get(url);
        Assertions.assertEquals(200, response.getStatusCode());

        int testGarnishID = Collections.max(garnishIDs);
        Main.deleteGarnish(testGarnishID);
    }

    @Then("The garnish should be deleted from the database")
    public void the_garnish_should_be_deleted_from_the_database() {

        response = RestAssured.get(url);
        String returnedString = response.getBody().asString();
        Assertions.assertFalse(returnedString.contains(name));
    }

}
