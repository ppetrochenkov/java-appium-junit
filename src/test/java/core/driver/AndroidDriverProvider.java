package core.driver;

import com.codeborne.selenide.WebDriverProvider;

import org.openqa.selenium.Capabilities;

import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

import config.ConfigReader;
import io.appium.java_client.android.AndroidDriver;

public interface AndroidDriverProvider extends WebDriverProvider {

    @Override
    @CheckReturnValue
    @Nonnull
    AndroidDriver createDriver(@Nonnull Capabilities capabilities);

    default URL getAppiumUrl() {
        try {
            return new URL(ConfigReader.runConfig.appiumUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
