package screens;

import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import core.selenide.SkipElementWaiting;
import static io.appium.java_client.AppiumBy.*;
import lombok.Getter;

@Getter
public class ApiCallsScreen extends BaseScreen {

    private SelenideAppiumElement devicesDataSection = $(className("android.widget.ScrollView"));

    @SkipElementWaiting
    private SelenideAppiumElement notFoundLabel = $(xpath("//android.widget.TextView[@text='Not found']"));

    public SelenideAppiumElement getSection(String section) {
        return $(xpath(String.format("//android.widget.TextView[@text='%s']", section)));
    }
}
