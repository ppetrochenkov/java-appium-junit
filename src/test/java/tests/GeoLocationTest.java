package tests;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.enabled;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import enums.AppSection;
import services.GeoService;
import core.selenide.DeviceGeoLocationUtils;
import screens.GeoLocationScreen;

public class GeoLocationTest extends BaseTest {

    private GeoLocationScreen geoLocationScreen;
    private GeoService geoService;

    @BeforeEach
    @DisplayName("Opening geo location")
    public void openGeoLocation() {
        navigationService.toAppSection(AppSection.GEO_LOCATION);
        geoLocationScreen = new GeoLocationScreen();
        geoService = new GeoService();
    }

    @Test
    @DisplayName("Validate retrieving user's coordinates in geo location service")
    public void testGeoLocation() {
        assertThat(geoService.getCoordinates())
                .isEqualTo(DeviceGeoLocationUtils.getDeviceLocation());
    }

    @Test
    @DisplayName("Validate geo location observing buttons")
    public void testGeoLocationObservingButtons() {
        geoLocationScreen.getStartObservingButton().shouldBe(disabled);

        geoService.stopObserving();
        geoLocationScreen.getStartObservingButton().shouldBe(enabled);

        geoService.startObserving();
        geoLocationScreen.getStopObservingButton().shouldBe(enabled);
    }
}
