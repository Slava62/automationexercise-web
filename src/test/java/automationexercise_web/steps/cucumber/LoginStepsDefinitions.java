package automationexercise_web.steps.cucumber;


import java.io.IOException;

import automationexercise_web.steps.serenity.LoginUserSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;


public class LoginStepsDefinitions {
    
    @Steps
    LoginUserSteps loginUserSteps;
    

    @Given("User has credentials")
    public void user_has_credentials() throws IOException {
        loginUserSteps.create_user();
    }

    @Given("User has incorrect email and password")
    public void user_has_incorrect_credentials() throws IOException {
        loginUserSteps.user_get_incorrect_credentials();
    }

    @When("User enter correct email address and password")
    public void user_enter_correct_name_and_email() {
        loginUserSteps.enter_correct_name_and_email();
        
    }
    @When("User enter incorrect email address and password")
    public void user_enter_incorrect_name_and_email() {
        loginUserSteps.enter_correct_name_and_email();   
    }

    @And("Click 'login' button")
    public void user_click_login_button() {
        loginUserSteps.click_login_button();
    }
    
    @Then("User Verify that {string} {string} is visible")
    public void user_verify_is_logged(String text, String username) {
        loginUserSteps.check_is_logged(text);
    }

    @Then("Verify error {string} is visible")
    public void user_verify_error(String errorMessage) throws IOException {
        loginUserSteps.verify_error(errorMessage);
    }

    @When("Click 'Logout' button")
    public void user_click_logout_button() {
        loginUserSteps.click_logout_button();
    }

    @Then("Verify that user is navigated to login page")
    public void user_verify_navigated_login_page() throws IOException {
        loginUserSteps.verify_navigated_login_page();
    }
}
