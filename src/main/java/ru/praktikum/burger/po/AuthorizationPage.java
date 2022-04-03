package ru.praktikum.burger.po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class AuthorizationPage extends HeaderPage {

    //Локатор поля "Email"
    @FindBy(how = How.CSS, using = ".text_type_main-default[name ='name']")
    private SelenideElement emailField;

    //Локатор поля "Пароль"
    @FindBy(how = How.CSS, using = ".text_type_main-default[name ='Пароль']")
    private SelenideElement passwordField;


    //Локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = ".//button[text() ='Войти']")
    public SelenideElement enterFromAuthorizationPageButton;

    //Локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//a[text() ='Зарегистрироваться']")
    private SelenideElement registrationButton;

    //Локатор кнопки "Восстановить пароль"
    @FindBy(how = How.XPATH, using = ".//a[text() ='Восстановить пароль']")
    private SelenideElement recoverPasswordButton;

    //Метод заполнения поля email
    public void setEmailField(String email) {
        emailField.setValue(email);
    }

    //Метод заполнения поля пароль
    public void setPasswordField(String password) {
        passwordField.setValue(password);
    }

    //Метод нажатия на кнопку Войти
    public MainPage clickEnterFromAuthorizationPageButton() {
        enterFromAuthorizationPageButton.click();
        return page(MainPage.class);

    }

    //Метод нажатия на кнопку Зарегистрироваться
    public RegistrationPage clickRegistrationButton() {
        registrationButton.click();
        return page(RegistrationPage.class);
    }

    //Метод нажатия на кнопку Востановить пароль
    public RecoverPasswordPage clickRecoverPasswordButton() {
        recoverPasswordButton.click();
        return page(RecoverPasswordPage.class);
    }
}
