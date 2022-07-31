package com.samy.mobtest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) {
        try {
            openGeoQuiz();
        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void openGeoQuiz() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "nexus");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "8.1.0");

        cap.setCapability("appPackage", "com.samy.the");
        cap.setCapability("appActivity", "com.samy.the.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, cap);

        MobileElement one_button = driver.findElement(By.id("one_button"));
        one_button.click();
        one_button.click();

        MobileElement multiply_button = driver.findElement(By.id("multiply_button"));
        multiply_button.click();

        MobileElement two_button = driver.findElement(By.id("two_button"));
        two_button.click();

        MobileElement equal_button = driver.findElement(By.id("equal_button"));
        equal_button.click();

        MobileElement type_field = driver.findElement(By.id("type_field"));
        if (type_field.getText().compareTo("22") == 0)
            System.out.println("OKAY");
    }
}