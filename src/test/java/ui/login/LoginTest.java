package ui.login;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ui.constants.CredentialsValues.PASSWORD;
import static ui.constants.CredentialsValues.PHONE;
import static ui.constants.URL.BASE_URL;

public class LoginTest {

    public LoginPage openPage(){
        return open(BASE_URL,LoginPage.class);
    }

    @Test
    @Tag("UI")
    @DisplayName("Check that user can't login with incorrect credentials")
    public void userCanLogin() {
       assertTrue(openPage().openLoginWindow().setCredentials(PHONE,PASSWORD).loginError());
    }

}
