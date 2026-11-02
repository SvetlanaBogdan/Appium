
package ru.netology.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class SecondPage {

    private final AndroidDriver driver;

    private final By text = AppiumBy.id(
            "ru.netology.testing.uiautomator:id/text");

    public SecondPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public String getDisplayedText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(text)
        ).getText();
    }
}
