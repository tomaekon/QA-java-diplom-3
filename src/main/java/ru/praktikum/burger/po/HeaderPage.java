package ru.praktikum.burger.po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class HeaderPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    //локатор кнопки Конструктор
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    //локатор логотипа StellarBurger
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement stellarBurgerLogo;

    //локатор кнопки Личный Кабинет
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement cabinetButton;

    //Метод нажатия на кнопку Конструктор
    public MainPage clickConstructorButton() {
        constructorButton.click();
        return page(MainPage.class);

    }

    //Метод нажатия на логотип StellarBurger
    public MainPage clickStellarBurgerLogo() {
        stellarBurgerLogo.click();
        return page(MainPage.class);

    }

    //Метод нажатия на кнопку Личный Кабинет до авторизации
    public AuthorizationPage clickCabinetButton() {
        cabinetButton.click();
        return page(AuthorizationPage.class);

    }

    //Метод нажатия на кнопку Личный Кабинет после авторизации
    public ClientCabinetPage clickCabinetButtonAfterAuthorization() {
        cabinetButton.click();
        return page(ClientCabinetPage.class);

    }


}
