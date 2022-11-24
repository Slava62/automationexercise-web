package automationexercise_web.steps.serenity;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

import java.io.IOException;
import java.time.Duration;
import java.util.function.Consumer;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;

import automationexercise_web.Util.TestUser;
import automationexercise_web.dto.User;
import automationexercise_web.pages.AccountCreatedPage;
import automationexercise_web.pages.LoginPage;
import automationexercise_web.pages.MainPage;
import automationexercise_web.pages.SignUpPage;
import automationexercise_web.steps.cucumber.TestContext;

public class RegisterUserSteps extends UIInteractionSteps {

    private static final Duration TIME_TO_WAIT = Duration.ofSeconds(30);
    User testUser;
    
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
    public void enter_name_and_email() {
        String name=testUser.getName();
        String email=testUser.getEmail();
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
    public void fill_details() {
        ListOfWebElementFacades elements=$$(signUpPage.getRadioInline());
        Consumer<WebElement> eConsumer = a -> {if(a.getText().compareTo(testUser.getTitle())==0) a.click();};
        elements.forEach(eConsumer);
        Assertions.assertThat($(signUpPage.getNameField()).getValue()).isEqualTo(testUser.getName());
        Assertions.assertThat($(signUpPage.getEmailField()).getValue()).isEqualTo(testUser.getEmail());
        Assertions.assertThat($(signUpPage.getEmailField()).isEnabled()).isFalse();
        $(signUpPage.getPassword()).sendKeys(testUser.getPassword());
        $(signUpPage.getDays()).selectByVisibleText(testUser.getBirthDay());
        $(signUpPage.getMonths()).selectByVisibleText(testUser.getBirthMonth());
        $(signUpPage.getYears()).selectByVisibleText(testUser.getBirthYear());
    }
    @Step
    public void select_checkbox_newsletter(String checkBoxText) {
        WebElement element=$("//*[text()='"+checkBoxText+"']").waitUntilVisible();
        Assertions.assertThat((element.getText())).isEqualTo(checkBoxText);
        element.click();
    }
    @Step
    //First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    public void fill_address_details() {
    $(signUpPage.getFirstName()).sendKeys(testUser.getFirstName());
    $(signUpPage.getLastName()).sendKeys(testUser.getLastName());
    $(signUpPage.getCompany()).sendKeys(testUser.getCompany());
    $(signUpPage.getAddress()).sendKeys(testUser.getAddress1());
    $(signUpPage.getAddress2()).sendKeys(testUser.getAddress2());
    $(signUpPage.getCountry()).selectByVisibleText(testUser.getCountry());
    $(signUpPage.getState()).sendKeys(testUser.getState());
    $(signUpPage.getCity()).sendKeys(testUser.getCity());
    $(signUpPage.getZipcode()).sendKeys(testUser.getZipcode());
    $(signUpPage.getMobile()).sendKeys(testUser.getMobile_number());
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
    public void check_is_logged(String text) {
        String tmp=withTimeoutOf(TIME_TO_WAIT).find("//*/a[text()=' "+text+" ']/b").getText();
        Assertions.assertThat(tmp).isEqualTo(testUser.getName());
    }
    @Step
    public void click_delete_account_button() {
        $("[href='/delete_account']").click();
    }
    @Step
    public void get_new_account_data() {
        this.testUser=(new TestContext()).getTestUser();
    }
    @Step
    public void get_existing_account_data() throws IOException {
        this.testUser=(new TestUser()).createNewUser(); 
    }
    @Step
    public void verify_error(String errorMessage) throws IOException {
        WebElement element=loginPage.find("//*[text()='"+errorMessage+"']").waitUntilVisible() ;
        Assertions.assertThat(element.isDisplayed()).isTrue();
        Assertions.assertThat(element.getAttribute("style").contains("color: red;")).isTrue();
        Assertions.assertThat((new TestUser()).deleteUser(testUser)).isTrue();
    }
}
