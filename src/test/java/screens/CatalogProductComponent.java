package screens;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import static io.appium.java_client.AppiumBy.*;

public class CatalogProductComponent {

    //TODO: investigate if separate CatalogProductComponent can be initialized with own page source
    // (trying to avoid using container property)
    private SelenideAppiumElement container;

    public CatalogProductComponent(SelenideAppiumElement container) {
        this.container = container;
    }

    public SelenideElement getImage() {
        return container.$(className("android.widget.ImageView"))
                .scrollTo();
    }

    public SelenideElement getName() {
        return container.$(accessibilityId("store item text"))
                .scrollTo();
    }

    public SelenideElement getPrice() {
        return container.$(accessibilityId("store item price"))
                .scrollTo();
    }

    public void open() {
        this.container.tap();
    }
}
