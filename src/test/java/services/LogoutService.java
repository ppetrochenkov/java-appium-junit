package services;

import static com.codeborne.selenide.Condition.visible;

import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import screens.LogoutDialog;

@Getter
@Slf4j
public class LogoutService {

    private LogoutDialog logoutDialog = new LogoutDialog();

    @Step("Logging out")
    public void logout() {
        log.info("Logging out from the application");
        logoutDialog.getLogoutButton().tap();
        logoutDialog.getSuccessLogoutLabel().shouldBe(visible);
    }

    public void submitSuccessfullyLogout() {
        logoutDialog.getOkButton().tap();
    }
}
