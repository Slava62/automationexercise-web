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
    public void user_check_message_is_visible(String text) {
        registerUserSteps.check_message_isvisible(text);
    }
    @Then("Verify that {string} caption is visible")
    public void user_check_caption_is_visible(String caption) {
        registerUserSteps.check_caption_isvisible(caption);
    }
    @When("User Fill details: Title, Name, Email, Password, Date of birth")
    public void user_fill_details() {
        registerUserSteps.fill_details(testUser);
    }

    @And("Select checkbox {string}")
    public void user_select_checkbox_newsletter(String checkBoxText) {
        registerUserSteps.select_checkbox_newsletter(checkBoxText);
    }

    @And("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void user_fill_address_details() {
        registerUserSteps.fill_address_details(testUser);
    }
    @And("Click 'Create Account button'")
    public void user_click_create_button() {
        registerUserSteps.click_create_button();
    }
    @And("Click 'Continue' button")
    public void user_click_continue_button() {
        registerUserSteps.click_continue_button();
    }

    @And("Verify that {string} {string} is visible")
    public void user_verify_is_logged(String text, String username) {
        registerUserSteps.check_is_logged(text,testUser.getName());
    }

    @Then("Click 'Delete Account' button")
    public void user_click_delete_account_button() {
        registerUserSteps.click_delete_account_button();
    }
    //https://automationexercise.com/delete_account
}
