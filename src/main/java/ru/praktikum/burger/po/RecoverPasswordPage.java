package ru.praktikum.burger.po;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RecoverPasswordPage extends HeaderPage {

    //Локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = ".//a[text() ='Войти']")
    private SelenideElement enterFromRecoverPageButton;

    //Метод нажатия на кнопку Войти
    @Step("Нажать на кнопку Войти в аккаунт")
    public AuthorizationPage clickEnterFromRecoverCabinetButton() {
        enterFromRecoverPageButton.click();
        return page(AuthorizationPage.class);
    }
}
