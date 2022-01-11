package com.tsi.training.aziz.mohammed.Cocktails;

import com.tsi.training.aziz.mohammed.Cocktails.controllers.Garnish;
import com.tsi.training.aziz.mohammed.Cocktails.repositories.GarnishRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AddAGarnishStepDef {

    @Autowired
    GarnishRepository garnishRepository;
    @Autowired
    main Main;

        Garnish garnish = new Garnish();
        String name;
        boolean food;

        Iterable<Garnish> actualGarnish;
        List<Integer> garnishIDs = new ArrayList<Integer>();

        Response response;
        //JsonPath json;




        @Given("I have added a name for the garnish")
        public void i_have_added_a_name_for_the_garnish(){
            //garnish.setName(name);
            name = "Test1234";
        }

        @Given("I have stated if the garnish is food or not")
        public void I_have_stated_if_the_garnish_is_food_or_not(){
            //garnish.setFood(food);
            food = false;
        }

        @When("I submit a request to add the garnish")
        public void i_submit_a_request_to_add_the_garnish(){

            //response = RestAssured.post("http://localhost:8080/cocktails/garnish/addGarnish?name=Test&food=false");
            String url = "http://localhost:8080/cocktails/garnish/getAll";
            response = RestAssured.get(url);
            Assertions.assertEquals(200, response.getStatusCode());
            Main.addAGarnish(name, food);
        }

        @Then("The garnish is saved to the database")
        public void the_glass_is_saved_to_the_database(){


            String returnedString = response.getBody().asString();
            Assertions.assertTrue(returnedString.contains(name));

            // Deleting the created glass
            actualGarnish = Main.getAllGarnishes();
            for (Garnish garnish: actualGarnish){
              garnishIDs.add(garnish.getIdGarnish());
            }
            int testGarnishID = Collections.max(garnishIDs);
            Main.deleteGarnish(testGarnishID);




        }
}
