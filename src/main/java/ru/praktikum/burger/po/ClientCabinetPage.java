package ru.praktikum.burger.po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ClientCabinetPage extends HeaderPage {
    //Локатор кнопки "Выход"
    @FindBy(how = How.XPATH, using = ".//button[text() ='Выход']")
    public SelenideElement exitButton;

    //Метод нажатия на кнопку Выход
    public AuthorizationPage clickExitButton() {
        exitButton.click();
        return page(AuthorizationPage.class);

    }
}
