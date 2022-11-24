package automationexercise_web.steps.cucumber;

import automationexercise_web.steps.serenity.RegisterUserSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MainStepsDefinitions {

    @Steps
    RegisterUserSteps registerUserSteps;

    @When("User navigate to url {string}")
    public void user_navigates_to_url(String url) {
        registerUserSteps.openMainPage(url);
    }

    @Then("User verify that home page is visible successfully")
    public void home_page_is_visible_successfully() {
        registerUserSteps.verify_home_page_visible();
    }

    @When("User click on {string} button")
    public void user_clicks_signUp_login_button(String buttonText) {
        registerUserSteps.click_signUp_login_nav_button();
    }

    @Then("Verify {string} is visible")
    public void text_is_visible_successfully(String text) {
        registerUserSteps.check_the_text_isvisible(text);
    }

}
