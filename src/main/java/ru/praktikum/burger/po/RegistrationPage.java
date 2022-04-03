package ru.praktikum.burger.po;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
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
    public SelenideElement incorrectPasswordString;


    //Метод нажатия на кнопку Войти
    public AuthorizationPage clickEnterButtonFromRegistrationPage() {
        enterFromRegistrationPageButton.click();
        return page(AuthorizationPage.class);

    }

    //Метод заполнения поля Имя
    public void setNameField(String name) {
        emailAndNameField.first().setValue(name);
    }

    //Метод заполнения поля Email
    public void setEmailField(String email) {
        emailAndNameField.last().setValue(email);
    }

    //Метод заполнения поля Пароль
    public void setPasswordField(String password) {
        emailAndNameField.last().setValue(password);
        passwordField.setValue(password);
    }

    //Метод нажатия на кнопку Зарегистрироваться c переходом на страницу авторизации
    public AuthorizationPage clickRegistrationButton() {
        registrationButton.click();
        return page(AuthorizationPage.class);

    }

    //Метод нажатия на кнопку Зарегистрироваться без перехода на страницу авторизации
    public RegistrationPage clickRegistrationWithErrorButton() {
        registrationButton.click();
        return page(RegistrationPage.class);

    }
}
