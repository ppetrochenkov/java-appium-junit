package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;

import core.driver.ConfigurationHelper;
import io.qameta.allure.selenide.AllureSelenide;
import services.NavigationService;

@ExtendWith({TextReportExtension.class})
public class BaseTest {

    protected String priceFormat = "^\\$\\d+\\.\\d{2}$";

    protected NavigationService navigationService;

    @BeforeAll
    @DisplayName("Setting up Selenide appium configuration")
    public static void setup() {
        ConfigurationHelper.setupConfiguration();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    @DisplayName("Driver initialization & app launching")
    public void startDriver() {
        SelenideAppium.launchApp();
        navigationService = new NavigationService();
    }

    @AfterEach
    @DisplayName("Driver tear down")
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
