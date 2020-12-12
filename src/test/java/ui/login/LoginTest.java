package ui.login;

import org.junit.jupiter.api.*;
import ui.SelenideSetUp;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ui.constants.CredentialsValues.*;
import static ui.constants.URL.BASE_URL;

public class LoginTest extends SelenideSetUp {

    public LoginPage openPage() {
        return open(BASE_URL, LoginPage.class);
    }

    @Test
    @Tag("UI")
    @DisplayName("Check that already registered user can`t re-registration")
    @Disabled
    public void alredyRegistred() {
        //have some problems with captcha
        assertTrue(openPage().openLoginWindow().openRegistrationTab().setRegistrationCredentials(NAME, REGISTERED_PHONE).registrationError());
    }

    @Test
    @Tag("UI")
    @DisplayName("Check that user can't login with incorrect credentials")
    public void loginIncorrectCred() {
        assertTrue(openPage().openLoginWindow().openLoginTab().setLoginCredentials(PHONE, PASSWORD).loginError());
    }

    @Test
    @Tag("UI")
    @DisplayName("Check that user can login with correct credentials")
    public void loginCorrectCred() {
        assertTrue(openPage().openLoginWindow().openLoginTab().setLoginCredentials(REGISTERED_PHONE, PASSWORD).successfulLogin());
    }
}
