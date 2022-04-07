package ru.praktikum.burger.po;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage extends HeaderPage {

    //Локаторы поля "Имя" и "Email"
    @FindBy(how = How.CSS, using = ".text_type_main-default[name = 'name']")
    private ElementsCollection emailAndNameField;

    //Локатор поля "Пароль"
    @FindBy(how = How.CSS, using = ".text_type_main-default[name ='Пароль']")
    private SelenideElement passwordField;

    //Локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = ".//a[text() ='Войти']")
    private SelenideElement enterFromRegistrationPageButton;

    //Локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//a[text() ='Войти']")
    private SelenideElement registrationButton;

    //Локатор ошибки "Некорректный пароль"
    @FindBy(how = How.XPATH, using = ".//p[text() ='Некорректный пароль']")
    private SelenideElement incorrectPasswordString;

    @Step("Нажать на кнопку Соусы")
    public AuthorizationPage clickEnterButtonFromRegistrationPage() {
        enterFromRegistrationPageButton.click();
        return page(AuthorizationPage.class);
    }

    @Step("Заполнить поле Имя")
    public void setNameField(String name) {
        emailAndNameField.first().setValue(name);
    }

    @Step("Заполнить поле Email")
    public void setEmailField(String email) {
        emailAndNameField.last().setValue(email);
    }

    @Step("Заполнить поле Пароль")
    public void setPasswordField(String password) {
        emailAndNameField.last().setValue(password);
        passwordField.setValue(password);
    }

    @Step("Нажать на кнопку Зарегистрироваться")
    public AuthorizationPage clickRegistrationButton() {
        registrationButton.click();
        return page(AuthorizationPage.class);
    }

    @Step("Нажать на кнопку Зарегистрироваться")
    public RegistrationPage clickRegistrationWithErrorButton() {
        registrationButton.click();
        return page(RegistrationPage.class);
    }
    @Step("Проверка отображения ошибки Некорректный пароль")
    public boolean isIncorrectPasswordStringIsDisplayed() {
        return incorrectPasswordString.isDisplayed();
    }
}
