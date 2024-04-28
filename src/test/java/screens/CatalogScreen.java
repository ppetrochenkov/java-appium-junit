package screens;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$$;

import com.codeborne.selenide.appium.SelenideAppiumCollection;

import java.util.ArrayList;
import java.util.List;

import static io.appium.java_client.AppiumBy.*;

public class CatalogScreen extends BaseScreen {

    @Override
    public boolean isOpened() {
        return $(xpath("//android.widget.TextView[@text='Products']"))
                .shouldBe(visible)
                .isDisplayed();
    }

    public CatalogProductComponent getProduct(String name) {
        String itemLocatorTemplate = "//android.view.ViewGroup[@content-desc='store item' and .//@text='%s']";
        return new CatalogProductComponent($(xpath(String.format(itemLocatorTemplate, name)))
                .scrollTo());
    }

    public List<CatalogProductComponent> getProducts() {
        SelenideAppiumCollection elementsCollection = $$(accessibilityId("store item"));
        List<CatalogProductComponent> products = new ArrayList<>();

        for(int i = 0; i < elementsCollection.size(); i++) {
            products.add(new CatalogProductComponent(elementsCollection.get(i)));
        }

        return products;
    }

}
