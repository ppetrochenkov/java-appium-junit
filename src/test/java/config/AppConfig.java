package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:app.properties"
})
public interface AppConfig extends Config {

    @Key("APP_PACKAGE")
    String appPackage();

    @Key("APP_ACTIVITY")
    String appActivity();

    @Key("APP")
    String app();

    @Key("WAIT_TIMEOUT")
    Long waitTimeout();
}
