import com.BrowserProperty;
import com.UserOperations;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.burger.po.AuthorizationPage;
import ru.praktikum.burger.po.ClientCabinetPage;
import ru.praktikum.burger.po.HeaderPage;
import ru.praktikum.burger.po.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class ClientCabinetFlowTest extends BrowserProperty {

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
    public void EnterToClientCabinetPageTest() {


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

        //Проверка перехода в личный кабинет
        clientCabinetPage.exitButton.shouldBe(Condition.visible);

    }
}
