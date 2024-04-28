package screens;

import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import static io.appium.java_client.AppiumBy.*;
import lombok.Getter;

@Getter
public class ProductViewScreen extends BaseScreen {

    private SelenideAppiumElement name = $(xpath("//android.view.ViewGroup[@content-desc='container header']/android.widget.TextView"));
    private SelenideAppiumElement image = $(className("android.widget.ImageView"));
    private SelenideAppiumElement price = $(accessibilityId("product price"));
    private SelenideAppiumElement availableColors = $(accessibilityId("gray circle"));
    private SelenideAppiumElement productCounter = $(accessibilityId("counter amount"));
    private SelenideAppiumElement addToCartButton = $(accessibilityId("Add To Cart button"));

}
