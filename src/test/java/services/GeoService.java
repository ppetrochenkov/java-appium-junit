package services;

import static com.codeborne.selenide.Condition.disabled;

import core.selenide.WaitUtils;
import entities.Coordinates;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import screens.GeoLocationScreen;

@Slf4j
public class GeoService {

    private GeoLocationScreen geoLocationScreen = new GeoLocationScreen();

    @Step("Starting geo location observing")
    public void startObserving() {
        log.info("Starting geo location observing");
        geoLocationScreen.getStartObservingButton().tap()
                .shouldBe(disabled);
    }

    @Step("Stopping geo location observing")
    public void stopObserving() {
        log.info("Stopping geo location observing");
        geoLocationScreen.getStopObservingButton().tap()
                .shouldBe(disabled);
    }

    @Step("Getting user's coordinates from app")
    public Coordinates getCoordinates() {
        log.info("Retrieving user's coordinates");
        this.waitForCoordinatesData();
        return new Coordinates()
                .setLatitude(getLatitudeValue())
                .setLongitude(getLongitudeValue());
    }

    private void waitForCoordinatesData() {
        WaitUtils.waitUntil(() -> getLongitudeValue() != 0 && getLongitudeValue() != 0);
    }

    private double getLatitudeValue() {
        return Double.parseDouble(geoLocationScreen.getLatitudeLabel().text());
    }

    private double getLongitudeValue() {
        return Double.parseDouble(geoLocationScreen.getLongitudeLabel().text());
    }
}
