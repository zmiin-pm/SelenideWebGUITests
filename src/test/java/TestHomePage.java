
import com.codeborne.selenide.Configuration;
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
    }

    @Test
    public void e2eHomeTest(){
        open("http://practice.automationtesting.in/");
        $("#main-nav-wrap a").click();
        $(By.xpath("//*[@id=\"content\"]/nav/a")).click();
        int number = $$(".products").size();
        Assert.assertEquals(number,3);
    }

    @Test
    public void userCanSearch() {
        google.open().searchFor("selenide");
        results.shouldHaveSize(6)
                .shouldHaveResult(1, "Selenide: concise UI tests in Java");
    }
}
