package automationexercise_web.pages;

import org.openqa.selenium.By;

import lombok.Getter;
import net.serenitybdd.core.pages.PageObject;

public class LoginPage extends PageObject{
    @Getter
    private By captionH2= By.cssSelector(".login-form h2");
    @Getter
    private By nameField=By.cssSelector("input[data-qa=\"signup-name\"]");
    @Getter
    private By emailField=By.cssSelector("input[data-qa=\"signup-email\"]");
    @Getter
    private By loginEmail=By.cssSelector("input[data-qa=\"login-email\"]");
    @Getter
    private By loginPassword=By.cssSelector("input[data-qa=\"login-password\"]");
    @Getter
    private By signUpButton=By.cssSelector("button[data-qa=\"signup-button\"]");
    @Getter
    private By loginButton=By.cssSelector("button[data-qa=\"login-button\"]");
    @Getter
    private By logoutButton=By.cssSelector("a[href=\"/logout\"]");   
}
