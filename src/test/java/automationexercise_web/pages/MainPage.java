package automationexercise_web.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import lombok.Getter;

public class MainPage extends PageObject {

    @Getter
    private By signUpLoginNavButton=By.cssSelector("a[href*=\"/login\"]");
    @Getter
    private By navBar=By.cssSelector("ul.navbar-nav");

}
