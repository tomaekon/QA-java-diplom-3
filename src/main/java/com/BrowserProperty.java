package com;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BrowserProperty {

    public void browserPropertySetUp(String browser) {

        if (browser.equals("yandex")) {
            System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\yandexdriver.exe");
        }
        Configuration.startMaximized=true;
    }
}
