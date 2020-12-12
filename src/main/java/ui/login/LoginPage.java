package ui.login;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static ui.constants.CredentialsValues.NAME;
import static ui.constants.NotificationString.LOGIN_ERROR_NOTIFICATION;
import static ui.constants.NotificationString.REGISTRATION_ERROR_NOTIFICATION;


public class LoginPage {

    private SelenideElement authButton = $(".auth-popup-button");
    private SelenideElement login = $("#modal-login-email-field");
    private SelenideElement password = $("#modal-login-password-field");
    private SelenideElement loginError = $(".login-error");
    private SelenideElement loginTab = $("#login-tab");
    private SelenideElement registrationName = $("#modal-registration-firstname");
    private SelenideElement registrationPhone = $("#modal-registration-tel");
    private SelenideElement registrationError = $(".error error_msg error_field");


    public LoginPage setLoginCredentials(String phone, String pass) {
        login.setValue(phone);
        password.setValue(pass).pressEnter();
        return this;
    }

    public LoginPage setRegistrationCredentials(String name, String phone) {
        registrationName.setValue(name);
        registrationPhone.click();
        registrationPhone.setValue(phone).pressEnter();
        return this;
    }

    public LoginPage openLoginWindow() {
        authButton.click();
        return this;
    }

    public LoginPage openLoginTab() {
        loginTab.click();
        return this;
    }

    public LoginPage openRegistrationTab() {
        $(By.linkText("Регистрация")).click();
        return this;
    }

    public boolean successfulLogin() {
        $(By.xpath("/html/body/header/div[1]/div/div/div[7]/button/span")).shouldHave(Condition.text(NAME));
        return true;
    }

    public boolean loginError() {
        loginError.shouldHave(text(LOGIN_ERROR_NOTIFICATION));
        return true;
    }

    public boolean registrationError() {
        registrationError.shouldHave(text(REGISTRATION_ERROR_NOTIFICATION));
        return true;
    }

}

