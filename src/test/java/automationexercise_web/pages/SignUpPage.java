package automationexercise_web.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import automationexercise_web.dto.User;

import java.time.Duration;
import java.util.function.IntPredicate;

public class SignUpPage extends PageObject {

    private static final Duration TIME_TO_WAIT = Duration.ofSeconds(30);

    private By captionH2= By.cssSelector("h2 b");
    private By titleMr=By.cssSelector("#id_gender1");
    private By titleMrs=By.cssSelector("#id_gender2");

    private By nameField=By.cssSelector("#name");
    private By emailField=By.cssSelector("#email");
    private By password=By.cssSelector("#password");

    private By days=By.cssSelector("[data-qa=days]");
    private By months=By.cssSelector("[data-qa=months]");
    private By years=By.cssSelector("[data-qa=years]");

    private By newsletter=By.cssSelector("[for=newsletter]");
    private By optin=By.cssSelector("[for=optin]");
    
    private By firstName=By.cssSelector("[data-qa=first_name]");
    private By lastName=By.cssSelector("[data-qa=last_name]");
    private By company=By.cssSelector("[data-qa=company]");

    
    private By address=By.cssSelector("[data-qa=address]");
    private By address2=By.cssSelector("[data-qa=address2]");
    private By country=By.cssSelector("#country");
    
    private By state=By.cssSelector("[data-qa=state]");
    private By city=By.cssSelector("[data-qa=city]");
    private By zipcode=By.cssSelector("#country");
    private By mobile=By.cssSelector("#mobile_number");
    
    private By createButton=By.cssSelector("[data-qa=create-account]");
   
    public boolean findText(String text) {
        String caption=$$(captionH2).get(0).waitUntilVisible().getText();
        return caption.compareTo(text)==0 ;
    }

    public boolean fillAccountDetales(User user) {
        if (user.getTitle().compareTo("0")==0){
            $(titleMr).waitUntilVisible().click();
        } else{
            $(titleMrs).waitUntilVisible().click();
        }
        if($(nameField).getValue().compareTo(user.getName())!=0){return false;}
        if($(emailField).getValue().compareTo(user.getEmail())!=0){return false;}
        if($(emailField).isEnabled()){return false;}
        $(password).sendKeys(user.getPassword());
        
        return true;
    }

    public boolean selectCheckboxNewsletter(String checkBoxText) {
        String tmp=$(newsletter).getText();
        if($(newsletter).getText().compareTo(checkBoxText)!=0){return false;}
        $(newsletter).click();
        return true;
    }
}
