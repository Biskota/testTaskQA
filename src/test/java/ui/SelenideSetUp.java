package ui;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class SelenideSetUp {

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().version("72").setup();
        Configuration.browser = "chrome";
        Configuration.browserVersion = "86.0.4240.22";
        Configuration.headless = true;
    }

    @AfterEach
    void shutDown() {
        closeWebDriver();
    }
}
