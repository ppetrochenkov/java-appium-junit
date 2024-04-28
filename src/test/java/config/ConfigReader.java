package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigReader {
    public static final AppConfig appConfig = ConfigFactory.create(AppConfig.class);
    public static final RunConfig runConfig = ConfigFactory.create(RunConfig.class);
    public static final EmulatorConfig emulatorConfig = ConfigFactory.create(EmulatorConfig.class);
}
