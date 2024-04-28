package tests;

import static com.codeborne.selenide.Condition.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import enums.AppSection;
import services.LoginService;
import services.LogoutService;

public class LoginTest extends BaseTest {

    private LoginService loginService;
    private LogoutService logoutService;

    @BeforeEach
    public void init() {
        navigationService.toAppSection(AppSection.LOGIN);
        loginService = new LoginService();
        logoutService = new LogoutService();
    }

    @Test
    @DisplayName("Validate login with invalid credentials")
    public void testLoginWithInvalidCredentials() {
        String invalidUserName = "invalid@test.com", invalidPassword = "123123";
        loginService.login(invalidUserName, invalidPassword);

        loginService.getLoginScreen().getCredentialsError()
                .shouldBe(visible)
                .shouldHave(text("Provided credentials do not match any user in this service"));
    }

    @Test
    @DisplayName("Validate login with valid credentials")
    public void testLoginWithValidCredentials() {
        String validUserName = "bob@example.com", validPassword = "10203040";
        loginService.login(validUserName, validPassword);

        navigationService.toAppSection(AppSection.LOGOUT);

        logoutService.getLogoutDialog().getDialogWarningLabel()
                .shouldBe(visible)
                .shouldHave(text("Are you sure you sure you want to logout?"));

        logoutService.logout();

        logoutService.getLogoutDialog().getSuccessLogoutLabel()
                .shouldBe(visible)
                .shouldHave(text("You are successfully logged out."));

        logoutService.submitSuccessfullyLogout();

        loginService.getLoginScreen().getLoginButton()
                .shouldBe(visible);
    }
}
