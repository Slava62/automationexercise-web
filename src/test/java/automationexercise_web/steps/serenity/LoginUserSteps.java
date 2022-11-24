package automationexercise_web.steps.serenity;

import automationexercise_web.Util.TestUser;
import automationexercise_web.dto.User;
import automationexercise_web.pages.LoginPage;
import automationexercise_web.steps.cucumber.TestContext;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

import java.io.IOException;
import java.time.Duration;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;

public class LoginUserSteps extends UIInteractionSteps {

    private static final Duration TIME_TO_WAIT = Duration.ofSeconds(30); 
    User testUser;
    LoginPage loginPage;

    @Step
    public void create_user() throws IOException{
        this.testUser=(new TestUser()).createNewUser();
        Assertions.assertThat(testUser == null).isFalse();
    }
    @Step
    public void enter_correct_name_and_email() {
        $(loginPage.getLoginEmail()).sendKeys(testUser.getEmail());
        $(loginPage.getLoginPassword()).sendKeys(testUser.getPassword());
    }
    @Step
    public void click_login_button() {
        $(loginPage.getLoginButton()).click();
    }
    @Step
    public void check_is_logged(String text) {
        String tmp=withTimeoutOf(TIME_TO_WAIT).find("//*/a[text()=' "+text+" ']/b").getText();
        Assertions.assertThat(tmp).isEqualTo(testUser.getName());
        System.out.println("login: " +testUser.getEmail());
        System.out.println("password: " +testUser.getPassword());
    }
    @Step
    public void user_get_incorrect_credentials() {
        this.testUser=(new TestContext()).getTestUser();
    }
    @Step
    public void verify_error(String errorMessage) throws IOException {
        WebElement element=loginPage.find("//*[text()='"+errorMessage+"']").waitUntilVisible() ;
        Assertions.assertThat(element.isDisplayed()).isTrue();
        Assertions.assertThat(element.getAttribute("style").contains("color: red;")).isTrue();
        Assertions.assertThat((new TestUser()).deleteUser(testUser)).isTrue();
    }
    @Step
    public void click_logout_button() {
        $(loginPage.getLogoutButton()).click();
    }
    @Step
    public void verify_navigated_login_page() throws IOException {  
        Assertions.assertThat(withTimeoutOf(TIME_TO_WAIT).find(loginPage.getCaptionH2()).getText()).isEqualTo("Login to your account");
        Assertions.assertThat((new TestUser()).deleteUser(testUser)).isTrue();
    }

}
