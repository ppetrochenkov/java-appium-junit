package core.driver;

import com.codeborne.selenide.Configuration;

import config.AppConfig;
import config.ConfigReader;
import config.RunConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConfigurationHelper {

    private static RunConfig runConfig = ConfigReader.runConfig;
    private static AppConfig appConfig = ConfigReader.appConfig;

    public static void setupConfiguration() {
        log.info("Setting up selenide appium device configuration");
        Configuration.browser = DriverFactory.getDeviceDriver(runConfig.deviceMode());
        Configuration.browserSize = null;
        Configuration.timeout = appConfig.waitTimeout();
    }
}
