package com.tsi.training.aziz.mohammed.Cocktails;


import com.tsi.training.aziz.mohammed.Cocktails.controllers.Glass;
import com.tsi.training.aziz.mohammed.Cocktails.repositories.GlassRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class AddAGlassStepDefinitions {


    @Autowired
    private GlassRepository glassRepository;

    private String name;
    private int volume;
    private Glass glass;




    @Given("I have added a name for the glass")
    public void i_have_added_a_name_for_the_glass() throws Throwable {
        name = "MARTINI";
    }

    @Given("I have added the volume of the glass")
    public void i_have_added_the_volume_of_the_glass() {
        volume = 200;
        }

    @When("I add the glass")
    public void i_add_the_glass() {
    System.out.println("Glass" + name + "with volume of" + volume + "has been added");
    }

    @Then("The glass should be stored")
    public void the_glass_should_be_stored() {
        System.out.println("the glass has been added");
           }




}