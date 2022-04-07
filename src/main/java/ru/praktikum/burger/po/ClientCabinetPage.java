package ru.praktikum.burger.po;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ClientCabinetPage extends HeaderPage {
    //Локатор кнопки "Выход"
    @FindBy(how = How.XPATH, using = ".//button[text() ='Выход']")
    private SelenideElement exitButton;

    @Step("Нажать на кнопку Выход")
    public AuthorizationPage clickExitButton() {
        exitButton.click();
        return page(AuthorizationPage.class);
    }
    @Step("Проверка отображения кнопки Выход")
    public boolean isExitButtonIsDisplayed() {
        return exitButton.isDisplayed();
    }
}
