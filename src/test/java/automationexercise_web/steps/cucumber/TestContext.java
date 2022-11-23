package automationexercise_web.steps.cucumber;

// import automationexercise.allure.env.EnvironmentInfo;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import automationexercise_web.dto.User;
import automationexercise_web.dto.Country;
import automationexercise_web.dto.Title;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;


public class TestContext {

    @Before(order=0)
    public void beforeScenario(Scenario scenario) {
        System.out.println("------------------------------");
        System.out.println("Starting - " + scenario.getName());
        System.out.println("------------------------------");
    }
    @After(order=0)
    public void afterScenario(Scenario scenario) {
        System.out.println("------------------------------");
        System.out.println("Ending - scenario");
        System.out.println("------------------------------");
        // EnvironmentInfo.setAllureEnvironment();
    }
    
    private JSONObject myObject;
    private User testUser;

    public TestContext() {
        testUser= create_set_account_data();
    }

    public User getTestUser() {
        return testUser;
    }
    private User create_set_account_data() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        Faker usFaker = new Faker(new Locale("en-US"));
        Date date=usFaker.date().birthday();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String st=new SimpleDateFormat("MMMM", Locale.forLanguageTag("en-GB")).format(date);
        return new User()
                .withName(usFaker.name().username())
                .withEmail(fakeValuesService.bothify("????##@gmail.com"))
                .withPassword(fakeValuesService.bothify("?#??##??"))
                .withTitle(usFaker.options().option(Title.class).getName())
                .withBirthDay(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)))
                .withBirthMonth(st)
                .withBirthYear(String.valueOf(cal.get(Calendar.YEAR)))
                .withFirstName(usFaker.name().firstName())
                .withLastName(usFaker.name().lastName())
                .withCompany(usFaker.company().name())
                .withAddress1(usFaker.address().fullAddress())
                .withAddress2(usFaker.address().secondaryAddress())
                .withCountry(usFaker.options().option(Country.class).getName())
                .withZipcode(usFaker.address().zipCode())
                .withState(usFaker.address().state())
                .withCity(usFaker.address().city())
                .withMobile_number(usFaker.phoneNumber().phoneNumber());
    }

}
