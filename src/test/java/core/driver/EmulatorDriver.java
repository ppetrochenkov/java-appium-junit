package core.driver;

import org.openqa.selenium.Capabilities;

import java.io.File;

import javax.annotation.Nonnull;

import config.ConfigReader;
import config.EmulatorConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmulatorDriver implements AndroidDriverProvider {

    private EmulatorConfig emulatorConfig = ConfigReader.emulatorConfig;

    @Nonnull
    @Override
    public AndroidDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = this.getDriverOptions();
        options.merge(capabilities);

        log.info(String.format("Starting new Emulator driver for %s device", options.getDeviceName()));

        return new AndroidDriver(this.getAppiumUrl(), options);
    }

    private UiAutomator2Options getDriverOptions() {
        return new UiAutomator2Options()
                .setPlatformName(emulatorConfig.platformName())
                .setUdid(emulatorConfig.udid())
                .setApp(new File(ConfigReader.appConfig.app()).getAbsolutePath())
                .setDeviceName(emulatorConfig.deviceName())
                .setAutomationName(emulatorConfig.appiumDriver())
                .setPlatformVersion(emulatorConfig.androidVersion())
                .setAutoGrantPermissions(true);
    }
}
