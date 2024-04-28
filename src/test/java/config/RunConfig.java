package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:run.properties"
})
public interface RunConfig extends Config {

    @Key("DEVICE_MODE")
    String deviceMode();

    @Key("APPIUM_URL")
    String appiumUrl();
}
