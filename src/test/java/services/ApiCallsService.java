package services;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import screens.ApiCallsScreen;

@Slf4j
public class ApiCallsService {

    private ApiCallsScreen apiCallsScreen = new ApiCallsScreen();

    @Step("Switching to the device section")
    public void openDeviceSection(String section) {
        log.info(String.format("Opening API calls section %s", section));
        apiCallsScreen.getSection(section).tap();
    }
}
