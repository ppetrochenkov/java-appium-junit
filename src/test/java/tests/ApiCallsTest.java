package tests;

import static com.codeborne.selenide.Condition.visible;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import enums.AppSection;
import services.ApiCallsService;
import screens.ApiCallsScreen;
import tests.BaseTest;

public class ApiCallsTest extends BaseTest {

    private ApiCallsService apiCallsService;
    private ApiCallsScreen apiCallsScreen;

    @BeforeEach
    public void init() {
        navigationService.toAppSection(AppSection.API_CALLS);
        apiCallsService = new ApiCallsService();
        apiCallsScreen = new ApiCallsScreen();
    }

    @Test
    @DisplayName("Validate US-DC device's section")
    public void testValidDataLoading() {
        apiCallsService.openDeviceSection("US-DC");
        apiCallsScreen.waitForScreenElementsLoad();

        apiCallsScreen.getDevicesDataSection().shouldBe(visible);
    }

    @Test
    @DisplayName("Validate 404 device's section")
    public void testNotFoundDataLoading() {
        apiCallsService.openDeviceSection("404");
        apiCallsScreen.getNotFoundLabel().shouldBe(visible);
    }
}
