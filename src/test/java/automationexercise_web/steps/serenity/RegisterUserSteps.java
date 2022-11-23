package automationexercise_web.steps.serenity;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.ArrayList;
import java.util.function.Consumer;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;

import automationexercise_web.dto.User;
import automationexercise_web.pages.AccountCreatedPage;
import automationexercise_web.pages.LoginPage;
import automationexercise_web.pages.MainPage;
import automationexercise_web.pages.SignUpPage;

public class RegisterUserSteps extends UIInteractionSteps {
    private static final Duration TIME_TO_WAIT = Duration.ofSeconds(30);
    private MainPage mainPage;
    private LoginPage loginPage;
    private SignUpPage signUpPage;
    private AccountCreatedPage accountCreatedPage;

    @Step
    public void openMainPage(String url) {
        mainPage.setDefaultBaseUrl(url);
        mainPage.open();
    }
    @Step
    public void verify_home_page_visible() {
      Assertions.assertThat(withTimeoutOf(TIME_TO_WAIT).find(mainPage.getNavBar()).isVisible()).isTrue();
    }
    @Step
    public void click_signUp_login_nav_button() {
        $(mainPage.getSignUpLoginNavButton()).waitUntilVisible().click();
    }
    @Step
    public void check_the_text_isvisible(String text) {
        WebElement element=loginPage.find("//*[text()='"+text+"']").waitUntilVisible() ;
        Assertions.assertThat(element.isDisplayed()).isTrue();
    }
    @Step
    public void enter_name_and_email(String name, String email) {
        Assertions.assertThat($(loginPage.getNameField()).waitUntilPresent().isPresent()).isTrue();
        Assertions.assertThat($(loginPage.getEmailField()).waitUntilPresent().isPresent()).isTrue();
        Assertions.assertThat($(loginPage.getSignUpButton()).waitUntilPresent().isPresent()).isTrue();
        WebElement element=$(loginPage.getNameField());
            element.clear();
            element.sendKeys(name);;
            element=$(loginPage.getEmailField());
            element.clear();
            element.sendKeys(email);;
    }
    @Step
    public void click_signup_button() {
        $(loginPage.getSignUpButton()).waitUntilClickable().click();
    }
    @Step
    public void check_message_isvisible(String text) {
        String caption;
        caption=findFirst(signUpPage.getCaptionH2()).get().waitUntilVisible().getText();
        Assertions.assertThat(caption.compareTo(text)==0).isTrue();
    }
    @Step
    //Title, Name, Email, Password, Date of birth
    public void fill_details(User user) {
        ListOfWebElementFacades elements=$$(signUpPage.getRadioInline());
        Consumer<WebElement> eConsumer = a -> {if(a.getText().compareTo(user.getTitle())==0) a.click();};
        elements.forEach(eConsumer);
        Assertions.assertThat($(signUpPage.getNameField()).getValue()).isEqualTo(user.getName());
        Assertions.assertThat($(signUpPage.getEmailField()).getValue()).isEqualTo(user.getEmail());
        Assertions.assertThat($(signUpPage.getEmailField()).isEnabled()).isFalse();
        $(signUpPage.getPassword()).sendKeys(user.getPassword());
        $(signUpPage.getDays()).selectByVisibleText(user.getBirthDay());
        $(signUpPage.getMonths()).selectByVisibleText(user.getBirthMonth());
        $(signUpPage.getYears()).selectByVisibleText(user.getBirthYear());
    }
    @Step
    public void select_checkbox_newsletter(String checkBoxText) {
        WebElement element=$("//*[text()='"+checkBoxText+"']").waitUntilVisible();
        Assertions.assertThat((element.getText())).isEqualTo(checkBoxText);
        element.click();
    }
    @Step
    //First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    public void fill_address_details(User user) {
    $(signUpPage.getFirstName()).sendKeys(user.getFirstName());
    $(signUpPage.getLastName()).sendKeys(user.getLastName());
    $(signUpPage.getCompany()).sendKeys(user.getCompany());
    $(signUpPage.getAddress()).sendKeys(user.getAddress1());
    $(signUpPage.getAddress2()).sendKeys(user.getAddress2());
    $(signUpPage.getCountry()).selectByVisibleText(user.getCountry());
    $(signUpPage.getState()).sendKeys(user.getState());
    $(signUpPage.getCity()).sendKeys(user.getCity());
    $(signUpPage.getZipcode()).sendKeys(user.getZipcode());
    $(signUpPage.getMobile()).sendKeys(user.getMobile_number());
    }
    @Step
    public void click_create_button() {
        $(signUpPage.getCreateButton()).click();
        // accountCreatedPage.openUrl("https://automationexercise.com/account_created");
    }
    @Step
    public void check_caption_isvisible(String text) {
        String caption;
            caption=$(accountCreatedPage.getAccountCreated()).waitUntilVisible().getText();
        Assertions.assertThat(caption.compareTo(text)==0).isTrue();
    }
    @Step
    public void click_continue_button() {
        $(accountCreatedPage.getContinueButton()).click();
    }
    @Step
    public void check_is_logged(String text, String username) {
        String tmp=withTimeoutOf(TIME_TO_WAIT).find("//*/a[text()=' "+text+" ']/b").getText();
        Assertions.assertThat(tmp).isEqualTo(username);
    }
    @Step
    public void click_delete_account_button() {
        $("[href='/delete_account']").click();
    }
}
