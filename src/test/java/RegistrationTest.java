import com.BrowserProperty;
import com.UserOperations;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.burger.po.*;

import java.util.Map;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationTest extends BrowserProperty {

    @Before
    public void startUp() {
        browserPropertySetUp("yandex");// chrome
        clearBrowserCookies();

    }

    @After
    public void tearDown() {
        UserOperations userOperations = new UserOperations();
        userOperations.delete();

    }

    @Test
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
        authorizationPageAfterRegistration.enterFromAuthorizationPageButton.shouldBe(Condition.visible);

    }

    @Test
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

        //Проверка наличия ошибки "Некорректный пароль"
        registrationPageAfterRegistration.incorrectPasswordString.shouldBe(Condition.visible);

    }


}

