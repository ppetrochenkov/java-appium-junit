package core.assertJCustom;

import com.codeborne.selenide.SelenideElement;

import org.assertj.core.api.AbstractAssert;

public class AppiumElementAssert extends AbstractAssert<AppiumElementAssert, SelenideElement> {

    public AppiumElementAssert(SelenideElement actual) {
        super(actual, AppiumElementAssert.class);
    }

    public static AppiumElementAssert assertThat(SelenideElement actual) {
        return new AppiumElementAssert(actual);
    }

    public AppiumElementAssert hasNotEmptyText() {
        isNotNull();
        if(actual.text().isEmpty()) {
            failWithMessage("Expected element to have not empty text");
        }

        return this;
    }

    public AppiumElementAssert hasText(String expectedText) {
        isNotNull();
        String actualText = actual.text();
        if(!actualText.equals(expectedText)) {
            failWithMessage("Expected actual text '%s' to equal to expected '%s'", actualText, expectedText);
        }

        return this;
    }
}
