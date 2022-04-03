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

public class EnterTest extends BrowserProperty {

    @Before
    public void startUp() {
        browserPropertySetUp("yandex");
        clearBrowserCookies();

    }

    @After
    public void tearDown() {
        UserOperations userOperations = new UserOperations();
        userOperations.delete();

    }

    @Test
    public void EnterFromMainPageTest() {


        MainPage mainPage = open(MainPage.URL, MainPage.class);

        AuthorizationPage authorizationPage = mainPage.clickEnterInAccountButton();

        UserOperations userOperations = new UserOperations();
        Map<String, String> responseData = userOperations.register();
        String email = responseData.get("email");
        String password = responseData.get("password");

        authorizationPage.setEmailField(email);
        authorizationPage.setPasswordField(password);

        MainPage mainPageAfterAuthorization = authorizationPage.clickEnterFromAuthorizationPageButton();

        //Проверка входа в личный кабинет
        mainPageAfterAuthorization.makeOderButton.shouldBe(Condition.visible);

    }

    @Test
    public void EnterFromAuthorizationPageTest() {


        HeaderPage headerPage = open(HeaderPage.URL, HeaderPage.class);
        AuthorizationPage authorizationPage = headerPage.clickCabinetButton();

        UserOperations userOperations = new UserOperations();
        Map<String, String> responseData = userOperations.register();
        String email = responseData.get("email");
        String password = responseData.get("password");

        authorizationPage.setEmailField(email);
        authorizationPage.setPasswordField(password);

        MainPage mainPageAfterAuthorization = authorizationPage.clickEnterFromAuthorizationPageButton();

        //Проверка входа в личный кабинет
        mainPageAfterAuthorization.makeOderButton.shouldBe(Condition.visible);

    }

    @Test
    public void EnterFromRegistrationPageTest() {


        HeaderPage headerPage = open(HeaderPage.URL, HeaderPage.class);
        AuthorizationPage authorizationPage = headerPage.clickCabinetButton();
        RegistrationPage registrationPage = authorizationPage.clickRegistrationButton();
        AuthorizationPage authorizationPageAfterClickEnter = registrationPage.clickEnterButtonFromRegistrationPage();

        UserOperations userOperations = new UserOperations();
        Map<String, String> responseData = userOperations.register();
        String email = responseData.get("email");
        String password = responseData.get("password");

        authorizationPageAfterClickEnter.setEmailField(email);
        authorizationPageAfterClickEnter.setPasswordField(password);

        MainPage mainPageAfterAuthorization = authorizationPage.clickEnterFromAuthorizationPageButton();

        //Проверка входа в личный кабинет
        mainPageAfterAuthorization.makeOderButton.shouldBe(Condition.visible);

    }

    @Test
    public void EnterFromRecoverPasswordPageTest() {


        HeaderPage headerPage = open(HeaderPage.URL, HeaderPage.class);
        AuthorizationPage authorizationPage = headerPage.clickCabinetButton();
        RecoverPasswordPage recoverPasswordPage = authorizationPage.clickRecoverPasswordButton();
        AuthorizationPage authorizationPageAfterClickEnter = recoverPasswordPage.clickEnterFromRecoverCabinetButton();

        UserOperations userOperations = new UserOperations();
        Map<String, String> responseData = userOperations.register();
        String email = responseData.get("email");
        String password = responseData.get("password");

        authorizationPageAfterClickEnter.setEmailField(email);
        authorizationPageAfterClickEnter.setPasswordField(password);

        MainPage mainPageAfterAuthorization = authorizationPage.clickEnterFromAuthorizationPageButton();

        //Проверка входа в личный кабинет
        mainPageAfterAuthorization.makeOderButton.shouldBe(Condition.visible);

    }


}

