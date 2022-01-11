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

//@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AddAGlassStepDef {

    @Autowired
    GlassRepository glassRepository;
    @Autowired
    main Main;


        String name;
        int volume;
        //int id = glass.getIdGlass();
        //RequestSpecification request;
        String url = "http://localhost:8080/cocktails/glass/getAll";
        Iterable<Glass> actualGlass;
        List<Integer> glassIDs = new ArrayList<Integer>();
        Response response;
        //JsonPath json;



    @Given("I have added a name for the glass")
    public void i_have_added_a_name_for_the_glass(){
        name = "Test1234";
        }

        @Given("I have added the volume of the glass")
        public void i_have_added_the_volume_of_the_glass(){
            volume = 500;
        }

        @When("I submit a request to add the glass")
        public void i_submit_a_request_to_add_the_glass(){


            response = RestAssured.get(url);
            Assertions.assertEquals(200, response.getStatusCode());
            Main.addAGLass(name, volume);
    }

        @Then("The glass is saved to the database")
        public void the_glass_is_saved_to_the_database(){

            response = RestAssured.get(url);

            String returnedString = response.getBody().asString();
            Assertions.assertTrue(returnedString.contains(name));
          // Assertions.assertEquals(glass.getVolume(), returnString);

            // Deleting the created glass
            actualGlass = Main.getAllGlasses();
            for (Glass glass: actualGlass){
                glassIDs.add(glass.getIdGlass());
            }
            int testGlassID = Collections.max(glassIDs);
            Main.deleteGlass(testGlassID);
        }





}