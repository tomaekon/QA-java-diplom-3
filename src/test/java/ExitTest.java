import com.BrowserProperty;
import com.UserOperations;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.burger.po.AuthorizationPage;
import ru.praktikum.burger.po.ClientCabinetPage;
import ru.praktikum.burger.po.HeaderPage;
import ru.praktikum.burger.po.MainPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class ExitTest extends BrowserProperty {

    @Before
    public void startUp() {
        browserPropertySetUp("chrome");
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
    @DisplayName("Проверка выхода из личного кабинета")
    public void ExitFromClientCabinetPageTest() {

        MainPage mainPage = open(MainPage.URL, MainPage.class);

        AuthorizationPage authorizationPage = mainPage.clickEnterInAccountButton();

        UserOperations userOperations = new UserOperations();
        Map<String, String> responseData = userOperations.register();
        String email = responseData.get("email");
        String password = responseData.get("password");

        authorizationPage.setEmailField(email);
        authorizationPage.setPasswordField(password);
        HeaderPage headerPage = authorizationPage.clickEnterFromAuthorizationPageButton();
        ClientCabinetPage clientCabinetPage = headerPage.clickCabinetButtonAfterAuthorization();
        AuthorizationPage authorizationPageAfterExit = clientCabinetPage.clickExitButton();

        Assert.assertFalse("Кнопка Войти на странице авторизации не отображается", authorizationPageAfterExit.isEnterFromAuthorizationPageButtonIsDisplayed());
    }
}

