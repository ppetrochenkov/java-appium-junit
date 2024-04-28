package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:emulator.properties"
})
public interface EmulatorConfig extends Config {

    @Key("PLATFORM_NAME")
    String platformName();

    @Key("UDID")
    String udid();

    @Key("DEVICE_NAME")
    String deviceName();

    @Key("APPIUM_DRIVER")
    String appiumDriver();

    @Key("ANDROID_VERSION")
    String androidVersion();

}
