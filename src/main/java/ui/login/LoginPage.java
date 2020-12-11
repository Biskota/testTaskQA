package ui.login;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static ui.constants.NotificationString.LOGIN_ERROR_NOTIFICATION;


public class LoginPage {

    private SelenideElement authButton =  $(".auth-popup-button");
    private SelenideElement login = $("#modal-login-email-field");
    private SelenideElement password = $("#modal-login-password-field");
    private SelenideElement loginError = $(".login-error");


    public LoginPage setCredentials(String phone, String pass){
        login.setValue(phone);
        password.setValue(pass).pressEnter();
        return this;
    }
    public LoginPage openLoginWindow(){
        authButton.click();
        return this;
    }

    public boolean loginError(){
        loginError.shouldHave(text(LOGIN_ERROR_NOTIFICATION));
        return true;
    }
}

