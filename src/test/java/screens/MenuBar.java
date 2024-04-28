package screens;


import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import static io.appium.java_client.AppiumBy.*;
import lombok.Getter;

@Getter
public class MenuBar {

    private SelenideAppiumElement expandMenuButton = $(accessibilityId("open menu"));
    private SelenideAppiumElement catalogSection = $(accessibilityId("menu item catalog"));
    private SelenideAppiumElement geoLocationSection = $(accessibilityId("menu item geo location"));
    private SelenideAppiumElement loginSection = $(accessibilityId("menu item log in"));
    private SelenideAppiumElement logoutSection = $(accessibilityId("menu item log out"));
    private SelenideAppiumElement apiCallsSection = $(accessibilityId("menu item api calls"));
    private SelenideAppiumElement cartButton = $(accessibilityId("cart badge"));
}
