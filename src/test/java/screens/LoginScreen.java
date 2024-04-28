package screens;

import static com.codeborne.selenide.appium.SelenideAppium.$;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import static io.appium.java_client.AppiumBy.*;
import lombok.Getter;
import core.selenide.SkipElementWaiting;

@Getter
public class LoginScreen extends BaseScreen {

    private SelenideAppiumElement userNameInput = $(accessibilityId("Username input field"));
    private SelenideAppiumElement passwordInput = $(accessibilityId("Password input field"));
    private SelenideAppiumElement loginButton = $(accessibilityId("Login button"));

    @SkipElementWaiting
    private SelenideAppiumElement credentialsError = $(xpath("//*[@content-desc='generic-error-message']/android.widget.TextView"));
}
