
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class TestHomePage {

    GooglePage google = new GooglePage();
    SearchResults results = new SearchResults();

    @BeforeClass
    public static void setup() {
        Configuration.baseUrl = "http://google.com/";
//        SelenideLogger.addListener("AllureSelenide",
//                new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test(priority = 1)
    public void e2eHomeTest(){
        open("http://practice.automationtesting.in/");
        $("#main-nav-wrap a").click();
        $(By.xpath("//*[@id=\"content\"]/nav/a")).click();

        int number = $$(".products").size();
        Assert.assertEquals(number,3);
    }

    @Test(priority = 2)
    public void userCanSearch() {
        google.open().searchFor("selenide");
        results.shouldHaveSize(5)
                .shouldHaveResult(1, "Selenide: concise UI tests in Java");
    }
}
