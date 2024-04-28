package core.selenide;

import com.codeborne.selenide.appium.AppiumDriverRunner;

import entities.Coordinates;
import io.appium.java_client.Location;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeviceGeoLocationUtils {

    public static Coordinates getDeviceLocation() {
        log.info("Retrieving device location");
        Location location = AppiumDriverRunner.getAndroidDriver().getLocation();

        return new Coordinates()
                .setLatitude(location.getLatitude())
                .setLongitude(location.getLongitude());
    }
}
