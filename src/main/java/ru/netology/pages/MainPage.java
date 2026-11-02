package ru.netology.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class MainPage {

    private final AndroidDriver driver;

    private final By userInput = AppiumBy.id(
            "ru.netology.testing.uiautomator:id/userInput");

    private final By buttonChange = AppiumBy.id(
            "ru.netology.testing.uiautomator:id/buttonChange");

    private final By buttonActivity = AppiumBy.id(
            "ru.netology.testing.uiautomator:id/buttonActivity");

    public MainPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void enterText(String text) {
        driver.findElement(userInput).sendKeys(text);
    }
    public void clickChangeText() {
        driver.findElement(buttonChange).click();
    }
    public void clickOpenActivity() {
        driver.findElement(buttonActivity).click();
    }

    public String getDisplayedText() {
        return driver.findElement(
                AppiumBy.id("ru.netology.testing.uiautomator:id/textToBeChanged")
        ).getText();
    }
}