package automationexercise_web.acceptancetests;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features", 
glue = "automationexercise_web.steps.cucumber", 
tags = "",//"@use", @positive not @ignored
plugin = {"pretty"})
public class UserAcceptanceTestSuite { }
