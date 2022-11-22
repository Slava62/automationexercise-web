package automationexercise_web.steps.cucumber;

import automationexercise_web.dto.User;
import automationexercise_web.steps.serenity.RegisterUserSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RegisterStepsDefinitions {

    User testUser;

    public RegisterStepsDefinitions() {
        this.testUser=new TestContext().getTestUser();
    }

    @Steps
    RegisterUserSteps registerUserSteps;

    @When("User enter name and email address")
    public void user_enter_name_and_email() {
        String name=testUser.getName();
        String email=testUser.getEmail();
        registerUserSteps.enter_name_and_email(name, email);
        
    }

    @And("Click 'Signup' button")
    public void user_click_signup_button() {
        registerUserSteps.click_signup_button();
    }
    
    @Then("Verify that {string} is visible")
    public void text_is_visible_successfully(String text) {
        registerUserSteps.check_the_details_isvisible(text);
    }
    @When("User Fill details: Title, Name, Email, Password, Date of birth")
    public void user_fill_details() {
        registerUserSteps.fill_details(testUser);
    }

    @And("Select checkbox {string}")
    public void user_select_checkbox_newsletter(String checkBoxText) {
        registerUserSteps.select_checkbox_newsletter(checkBoxText);
    }

    // @Then("Verify  is visible")
    // public void text_is_visible_successfully(String text) {
    //     mainSteps.check_the_text_isvisible(text);
    // }

    
}
