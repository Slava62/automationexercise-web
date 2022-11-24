package automationexercise_web.pages;

import org.openqa.selenium.By;

import lombok.Getter;
import net.serenitybdd.core.pages.PageObject;

public class AccountDeletedPage extends PageObject {
    @Getter
    private By accountDeleted=By.cssSelector("h2.title");
    @Getter
    private By ContinueButton=By.cssSelector("[data-qa=\"continue-button\"]"); 
}