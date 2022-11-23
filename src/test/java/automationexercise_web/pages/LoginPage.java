package automationexercise_web.pages;

import org.openqa.selenium.By;

import lombok.Getter;
import net.serenitybdd.core.pages.PageObject;

public class LoginPage extends PageObject{
    @Getter
    private By nameField=By.cssSelector("input[data-qa=\"signup-name\"]");
    @Getter
    private By emailField=By.cssSelector("input[data-qa=\"signup-email\"]");
    @Getter
    private By signUpButton=By.cssSelector("button[data-qa=\"signup-button\"]");
    
}
