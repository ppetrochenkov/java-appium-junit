package services;

import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import screens.LoginScreen;

@Getter
@Slf4j
public class LoginService {

    private LoginScreen loginScreen = new LoginScreen();

    @Step("Signing in")
    public void login(String userName, String password) {
        log.info(String.format("Signing in with user %s / %s", userName, password));
        loginScreen.waitForScreenElementsLoad();
        loginScreen.getUserNameInput().setValue(userName);
        loginScreen.getPasswordInput().setValue(password);
        loginScreen.getLoginButton().tap();
    }
}
