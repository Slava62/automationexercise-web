package automationexercise_web.pages;


import java.util.function.IntPredicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;

public class LoginPage extends PageObject{

    private By nameField=By.cssSelector("input[data-qa=\"signup-name\"]");
    private By emailField=By.cssSelector("input[data-qa=\"signup-email\"]");
    private By signUpButton=By.cssSelector("button[data-qa=\"signup-button\"]");


    public boolean findText(String text) {
        return $("//*[ contains (text(), '"+text+"' ) ]").waitUntilVisible().isVisible() ;
    }

    public boolean signUpFormElementsIsPresent() {
        boolean checker=$(nameField).waitUntilPresent().isPresent();
                checker=$(emailField).waitUntilPresent().isPresent();
                checker=$(signUpButton).waitUntilPresent().isPresent();
        return checker;
    }

    public void enterNameAndEmail(String name, String email) {
       WebElement element=$(nameField);
        element.clear();
        element.sendKeys(name);;
        element=$(emailField);
        element.clear();
        element.sendKeys(email);
    }

    public void clickSignUpButton() {
        $(signUpButton).waitUntilClickable().click();
    }

    
}
