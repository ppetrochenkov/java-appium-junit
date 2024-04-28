package screens;

import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import static io.appium.java_client.AppiumBy.*;
import lombok.Getter;
import core.selenide.SkipElementWaiting;

@Getter
public class LogoutDialog extends BaseScreen {

    private SelenideAppiumElement dialogWarningLabel = $(id("android:id/message"));
    private SelenideAppiumElement logoutButton = $(xpath("//android.widget.Button[@text='LOG OUT']"));

    @SkipElementWaiting
    private SelenideAppiumElement successLogoutLabel = $(id("android:id/alertTitle"));

    @SkipElementWaiting
    private SelenideAppiumElement okButton = $(xpath("//android.widget.Button[@text='OK']"));
}
