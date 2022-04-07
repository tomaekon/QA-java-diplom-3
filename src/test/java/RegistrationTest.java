import com.BrowserProperty;
import com.UserOperations;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.burger.po.*;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;


public class RegistrationTest extends BrowserProperty {

    @Before
    public void startUp() {
        browserPropertySetUp("chrome");// chrome
        clearBrowserCookies();
    }

    @After
    public void tearDown() {
        UserOperations userOperations = new UserOperations();
        userOperations.delete();
        closeWindow();
        closeWebDriver();
    }

    @Test
    @DisplayName("Проверка перехода успешной регистрации пользователя")
    public void UserSuccessRegistrationTest() {

        HeaderPage headerPage = open(HeaderPage.URL, HeaderPage.class);
        AuthorizationPage authorizationPage = headerPage.clickCabinetButton();
        RegistrationPage registrationPage = authorizationPage.clickRegistrationButton();

        UserOperations userOperations = new UserOperations();
        Map<String, String> responseData = userOperations.register();
        String email = responseData.get("email");
        String password = responseData.get("password");
        String name = responseData.get("name");

        registrationPage.setNameField(name);
        registrationPage.setEmailField(email);
        registrationPage.setPasswordField(password);

        AuthorizationPage authorizationPageAfterRegistration = registrationPage.clickRegistrationButton();

        //Проверка осущетвлен ли переход на страницу Авторизации(наличие кнопки Войти)
        Assert.assertTrue("Кнопка Войти на странице авторизации не отображается", authorizationPageAfterRegistration.isEnterFromAuthorizationPageButtonIsDisplayed());
    }

    @Test
    @DisplayName("Проверка ошибки регистрации, слишком короткий пароль")
    public void UserAuthorizationWithIncorrectPasswordTest() {

        HeaderPage headerPage = open(HeaderPage.URL, HeaderPage.class);
        AuthorizationPage authorizationPage = headerPage.clickCabinetButton();
        RegistrationPage registrationPage = authorizationPage.clickRegistrationButton();

        UserOperations userOperations = new UserOperations();
        Map<String, String> responseData = userOperations.register();
        responseData.put("password", "12345");
        String email = responseData.get("email");
        String password = responseData.get("password");
        String name = responseData.get("name");

        registrationPage.setNameField(name);
        registrationPage.setEmailField(email);
        registrationPage.setPasswordField(password);

        RegistrationPage registrationPageAfterRegistration = registrationPage.clickRegistrationWithErrorButton();

        Assert.assertTrue("Надпись Некорректный пароль не отображается", registrationPageAfterRegistration.isIncorrectPasswordStringIsDisplayed());
    }

}

