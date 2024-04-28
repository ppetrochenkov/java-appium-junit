package screens;

import static com.codeborne.selenide.appium.SelenideAppium.$;
import static io.appium.java_client.AppiumBy.*;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import core.selenide.SkipElementWaiting;
import lombok.Getter;

@Getter
public class CartScreen extends BaseScreen {

    private SelenideAppiumElement image = $(className("android.widget.ImageView"));
    private SelenideAppiumElement name = $(accessibilityId("product label"));
    private SelenideAppiumElement price = $(accessibilityId("product price"));
    private SelenideAppiumElement color = $(accessibilityId("gray circle"));
    private SelenideAppiumElement productCounter = $(accessibilityId("counter amount"));
    private SelenideAppiumElement removeItemButton = $(accessibilityId("remove item"));
    private SelenideAppiumElement proceedToCheckoutButton = $(accessibilityId("Proceed To Checkout button"));

    @SkipElementWaiting
    private SelenideAppiumElement noItemsLabel = $(xpath("//android.widget.TextView[@text='No Items']"));
    @SkipElementWaiting
    private SelenideAppiumElement goShoppingButton = $(accessibilityId("Go Shopping button"));

}
