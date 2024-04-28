package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties"
})
public interface AwsDeviceFarmConfig extends Config {

    @Key("DEVICEFARM_DEVICE_NAME")
    String deviceFarmDeviceName();
}
