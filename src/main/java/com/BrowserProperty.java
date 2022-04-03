package com;

public class BrowserProperty {

    public void browserPropertySetUp(String browser) {
        if (browser.equals("yandex")) {
            System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\yandexdriver.exe");
        } else return;
    }
}
