import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.collections.SizeGreaterThan;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResults {
    private final ElementsCollection elements = $$(".g");

    public SearchResults shouldHaveSize(int size) {
        elements.shouldHave(new SizeGreaterThan(size));
        return this;
    }

    public SearchResults shouldHaveResult(int index, String text) {
        elements.get(index).shouldHave(text(text));
        return this;
    }
}
