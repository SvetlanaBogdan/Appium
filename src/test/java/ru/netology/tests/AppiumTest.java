
package ru.netology.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import ru.netology.pages.MainPage;
import ru.netology.pages.SecondPage;

import java.net.URL;

public class AppiumTest {

    private AndroidDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("ru.netology.testing.uiautomator");
        options.setAppActivity(".MainActivity");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void testEmptyInput() {
        MainPage mainPage = new MainPage(driver);

        String textBefore = mainPage.getDisplayedText();

        mainPage.enterText("");
        mainPage.clickChangeText();

        String textAfter = mainPage.getDisplayedText();

        assertEquals(textBefore, textAfter);
    }

    @Test
    public void testOpenTextInAnotherActivity() {
        MainPage mainPage = new MainPage(driver);

        mainPage.enterText("Netology");
        mainPage.clickOpenActivity();

        SecondPage secondPage = new SecondPage(driver);

        assertEquals("Netology", secondPage.getDisplayedText());
    }
}
