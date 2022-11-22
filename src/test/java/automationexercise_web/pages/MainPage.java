package automationexercise_web.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import java.time.Duration;
import java.util.List;
import java.util.function.IntPredicate;

public class MainPage extends PageObject {

    private static final Duration TIME_TO_WAIT = Duration.ofSeconds(30);
    // private static final String PAGE_BLOCK_CAPTION = "Медицинские услуги в Москве";
    // public static final int TAB_INDEX=0;

    // private By subItemClickingLocator= By.cssSelector(".result-item__number");
    // private By tabBlock=By.cssSelector(".tab-block");
    // private By tabs =By.cssSelector(".side-bar-second__items");//
    private By signUpLoginNavButton=By.cssSelector("a[href*=\"/login\"]");
    private By navBar=By.cssSelector("ul.navbar-nav");

    public void openSignUpLoginPage() {
        // WebElementFacade content = withTimeoutOf(TIME_TO_WAIT).find(tabBlock).waitUntilPresent();// .waitUntilVisible();
        // List<WebElementFacade> items = content.thenFindAll(tabs);
        // items.get(TAB_INDEX).waitUntilVisible().click();
        $(signUpLoginNavButton).waitUntilVisible().click();
    }

    public Boolean navBarIsVisible() {
        WebElementFacade eNavBar=withTimeoutOf(TIME_TO_WAIT).find(navBar).waitUntilPresent();;
        return eNavBar.isPresent();
    }

    // public List<WebElementFacade> getSubItems(){
    //     WebElementFacade content = withTimeoutOf(TIME_TO_WAIT).find(tabBlock).waitUntilPresent();// .waitUntilVisible();
    //     List<WebElementFacade> items = content.thenFindAll(mrtBlock);
    //     return items;
    // }

    // public void clickSubItem(int Index){
    //     //WebElementFacade content = withTimeoutOf(TIME_TO_WAIT).find(By.className("result-item__number"));
    //     getSubItems().get(Index).waitUntilVisible().click();
    // }

    // public List<WebElementFacade> getSubItemClickingResult(){
    //     WebElementFacade content = withTimeoutOf(TIME_TO_WAIT).find(By.className("pagination-items")).waitUntilPresent();
    //     return content.thenFindAll(subItemClickingLocator);
    // }

    // public Boolean checkRadiologyPageIsOpened() {
    //     this.open();
    //     WebElementFacade news_block =withTimeoutOf(TIME_TO_WAIT).find(By.cssSelector(".title-block")).waitUntilPresent();
    //     String temp=news_block.thenFind("h1").getText();
    //     System.out.println("PAGE_BLOCK_CAPTION : "+temp);
    //     return true;//temp.matches(PAGE_BLOCK_CAPTION);

    // }


    
}
