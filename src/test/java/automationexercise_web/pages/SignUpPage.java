package automationexercise_web.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import lombok.Getter;

public class SignUpPage extends PageObject {

    @Getter
    private By captionH2= By.cssSelector("h2 b");
    @Getter
    private By titleMr=By.cssSelector("#id_gender1");
    @Getter
    private By titleMrs=By.cssSelector("#id_gender2");
    @Getter
    private By radioInline=By.cssSelector(".radio-inline");
    @Getter
    private By nameField=By.cssSelector("#name");
    @Getter
    private By emailField=By.cssSelector("#email");
    @Getter
    private By password=By.cssSelector("#password");
    @Getter
    private By days=By.cssSelector("[data-qa=days]");
    @Getter
    private By months=By.cssSelector("[data-qa=months]");
    @Getter
    private By years=By.cssSelector("[data-qa=years]");
    @Getter
    private By newsletter=By.cssSelector("[for=newsletter]");
    @Getter
    private By optin=By.cssSelector("[for=optin]");
    @Getter
    private By firstName=By.cssSelector("[data-qa=first_name]");
    @Getter
    private By lastName=By.cssSelector("[data-qa=last_name]");
    @Getter
    private By company=By.cssSelector("[data-qa=company]");
    @Getter
    private By address=By.cssSelector("[data-qa=address]");
    @Getter
    private By address2=By.cssSelector("[data-qa=address2]");
    @Getter
    private By country=By.cssSelector("#country");
    @Getter
    private By state=By.cssSelector("[data-qa=state]");
    @Getter
    private By city=By.cssSelector("[data-qa=city]");
    @Getter
    private By zipcode=By.cssSelector("#zipcode");
    @Getter
    private By mobile=By.cssSelector("#mobile_number");
    @Getter
    private By createButton=By.cssSelector("[data-qa=create-account]");
 }
