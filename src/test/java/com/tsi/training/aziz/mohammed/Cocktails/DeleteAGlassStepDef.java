package com.tsi.training.aziz.mohammed.Cocktails;

import com.tsi.training.aziz.mohammed.Cocktails.controllers.Glass;
import com.tsi.training.aziz.mohammed.Cocktails.repositories.GlassRepository;
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
public class DeleteAGlassStepDef {

    @Autowired
    GlassRepository glassRepository;
    @Autowired
    main Main;

    String name = "test12345";
    int volume = 500;
    Iterable<Glass> deleteGlassList;
    String url = "http://localhost:8080/cocktails/glass/getAll";
    List<Integer> glassIDs = new ArrayList<Integer>();
    Response response;


    @Given("There is a glass in the database to be deleted")
    public void there_is_a_glass_in_the_database_to_be_deleted(){
        Main.addAGLass(name, volume);
    }

    @Given("I have provided the glass ID")
    public void i_have_provided_the_glass_ID(){
        deleteGlassList = Main.getAllGlasses();
        for (Glass glass: deleteGlassList){
            glassIDs.add(glass.getIdGlass());
        }
    }

    @When("I submit a request to delete the glass")
    public void i_submit_a_request_to_delete_the_glass(){


        response = RestAssured.get(url);
        Assertions.assertEquals(200, response.getStatusCode());

        int testGlassID = Collections.max(glassIDs);
        Main.deleteGlass(testGlassID);
    }

    @Then("The glass should be deleted from the database")
    public void the_glass_should_be_deleted_from_the_database(){

        response = RestAssured.get(url);
        String returnedString = response.getBody().asString();
        Assertions.assertFalse(returnedString.contains(name));
    }

}
