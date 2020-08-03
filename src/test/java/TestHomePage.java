
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class TestHomePage {

    @Test
    public void e2eHomeTest(){
        open("http://practice.automationtesting.in/");
        $("#main-nav-wrap a").click();
        $(By.xpath("//*[@id=\"content\"]/nav/a")).click();
        int number = $$(".products").size();
        Assert.assertEquals(number,3);
    }
}
