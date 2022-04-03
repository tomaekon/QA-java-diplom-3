import com.BrowserProperty;
import com.UserOperations;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.burger.po.AuthorizationPage;
import ru.praktikum.burger.po.ClientCabinetPage;
import ru.praktikum.burger.po.HeaderPage;
import ru.praktikum.burger.po.MainPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;

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

    }

    @Test
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

        //Проверка перехода на страницу авторизации
        authorizationPageAfterExit.enterFromAuthorizationPageButton.shouldBe(Condition.visible);

    }
}

