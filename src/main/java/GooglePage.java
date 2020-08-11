import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GooglePage {

    public GooglePage open() {
        Selenide.open("/");
        return this;
    }

    public GooglePage searchFor(String text) {
        $(By.name("q")).val(text).pressEnter();
        return this;
    }

}
