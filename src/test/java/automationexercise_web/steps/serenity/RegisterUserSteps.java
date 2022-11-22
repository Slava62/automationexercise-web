package automationexercise_web.steps.serenity;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;

import automationexercise_web.dto.User;
import automationexercise_web.pages.LoginPage;
import automationexercise_web.pages.MainPage;
import automationexercise_web.pages.SignUpPage;

public class RegisterUserSteps extends UIInteractionSteps {

    private MainPage mainPage;
    private LoginPage loginPage;
    private SignUpPage signUpPage;

    @Step
    public void openMainPage(String url) {
        mainPage.setDefaultBaseUrl(url);
        mainPage.open();
    }
    @Step
    public void verify_home_page_visible() {
      Assertions.assertThat(mainPage.navBarIsVisible()).isTrue();
    }
    @Step
    public void click_signUp_login_nav_button() {
        mainPage.openSignUpLoginPage();
    }
    @Step
    public void check_the_text_isvisible(String text) {
        Assertions.assertThat(loginPage.findText(text)).isTrue();
    }
    @Step
    public void enter_name_and_email(String name, String email) {
        Assertions.assertThat(loginPage.signUpFormElementsIsPresent()).isTrue();
        loginPage.enterNameAndEmail(name,email);
    }
    @Step
    public void click_signup_button() {
        loginPage.clickSignUpButton();
    }
    @Step
    public void check_the_details_isvisible(String text) {
        Assertions.assertThat(signUpPage.findText(text)).isTrue();
    }
    @Step
    public void fill_details(User user) {
        Assertions.assertThat(signUpPage.fillAccountDetales(user)).isTrue();
    }

    public void select_checkbox_newsletter(String checkBoxText) {
        Assertions.assertThat(signUpPage.selectCheckboxNewsletter(checkBoxText)).isTrue();
    }
}
