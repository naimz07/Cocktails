package com.tsi.training.aziz.mohammed.Cocktails;


import com.tsi.training.aziz.mohammed.Cocktails.controllers.Glass;
import com.tsi.training.aziz.mohammed.Cocktails.repositories.GlassRepository;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class AddAGlassStepDefinitions {


    @Autowired
    private GlassRepository glassRepository;

    private String name;
    private int volume;
    private Glass glass;




    @Given("I have added a name for the glass")
    public void i_have_added_a_name_for_the_glass(String name) throws Throwable {

        throw new PendingException();
    }

//    @Given("I have added the volume of the glass")
//    public void i_have_added_the_volume_of_the_glass() {
//        volume = 200;
//        throw new PendingException();    }
//
//    @When("I add the glass")
//    public String i_add_the_glass() {
//
//        throw new PendingException();    }
//
//    @Then("The glass should be stored")
//    public void the_glass_should_be_stored() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();    }
//



}