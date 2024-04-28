package screens;

import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import static io.appium.java_client.AppiumBy.*;
import lombok.Getter;

@Getter
public class GeoLocationScreen extends BaseScreen {

    private SelenideAppiumElement latitudeLabel = $(accessibilityId("latitude data"));
    private SelenideAppiumElement longitudeLabel = $(accessibilityId("longitude data"));
    private SelenideAppiumElement startObservingButton = $(accessibilityId("Start Observing button"));
    private SelenideAppiumElement stopObservingButton = $(accessibilityId("Stop Observing button"));

}
