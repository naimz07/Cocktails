package com.tsi.training.aziz.mohammed.Cocktails;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
                 features = "src/test/resources/cucumber")
                 //glue = "src/test/java/com/tsi/training/aziz/mohammed/Cocktails")


public class RunCucumberTest {
}
