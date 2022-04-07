package ru.praktikum.burger.po;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;


public class MainPage extends HeaderPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    //Локатор неактивных кнопок "Булки", "Соусы", "Начинки"
    @FindBy(how = How.CSS, using = ".tab_tab__1SPyG")
    private ElementsCollection nonActiveButton;

    //Локатор активной кнопки "Булки"/"Соусы"/"Начики"
    @FindBy(how = How.CSS, using = ".tab_tab_type_current__2BEPc")
    private SelenideElement activeButton;

    //Локатор кнопки "Надписи Булки"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    private SelenideElement bunString;

    //Локатор кнопки "Надписи Соусы"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    private SelenideElement sauceString;

    //Локатор кнопки "Надписи Начинки"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    private SelenideElement fillingString;

    //Локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = ".//button[text() ='Войти в аккаунт']")
    private SelenideElement enterInAccountButton;

    //Локатор кнопки "Оформить заказ"
    @FindBy(how = How.XPATH, using = ".//button[text() ='Оформить заказ']")
    private SelenideElement makeOderButton;

    @Step("Нажать на кнопку Булки")
    public MainPage clickBunButton() {
        nonActiveButton.get(0).click();
        return page(MainPage.class);
    }

    @Step("Нажать на кнопку Соусы")
    public MainPage clickSauseButton() {
        nonActiveButton.get(1).click();
        return page(MainPage.class);
    }

    @Step("Нажать на кнопку Начинки")
    public MainPage clickFillingButton() {
        nonActiveButton.get(2).click();
        return page(MainPage.class);
    }

    @Step("Нажать на кнопку Войти в аккаунт")
    public AuthorizationPage clickEnterInAccountButton() {
        enterInAccountButton.click();
        return page(AuthorizationPage.class);
    }
    @Step("Получение текста активной кнопки")
    public String getTextActiveButton() {
        return  activeButton.getText();
    }
    @Step("Проверка отображения кнопки Оформить заказ")
    public boolean isMakeOderButtonIsDisplayed() {
        return makeOderButton.isDisplayed();
    }
}

