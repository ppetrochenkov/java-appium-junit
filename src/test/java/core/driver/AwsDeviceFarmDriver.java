package core.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;

import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AwsDeviceFarmDriver implements AndroidDriverProvider {

    @Nonnull
    @Override
    public AndroidDriver createDriver(@Nonnull Capabilities capabilities) {
        DesiredCapabilities options = new DesiredCapabilities();
        options.merge(capabilities);

        log.info(String.format("Starting new AWS device farm driver for %s device",
                options.getCapability("appium:deviceName")));

        return new AndroidDriver(this.getAppiumUrl(), options);
    }
}
