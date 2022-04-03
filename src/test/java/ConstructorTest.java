import com.BrowserProperty;
import com.UserOperations;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.burger.po.AuthorizationPage;
import ru.praktikum.burger.po.ClientCabinetPage;
import ru.praktikum.burger.po.HeaderPage;
import ru.praktikum.burger.po.MainPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.hamcrest.CoreMatchers.containsString;

public class ConstructorTest extends BrowserProperty {


    @Before
    public void startUp() {
        browserPropertySetUp("chrome");
        clearBrowserCookies();
    }

    @After
    public void tearDown() {}

    @Test
    public void ClickToBunButtonTest() throws InterruptedException {


        MainPage mainPage = open(MainPage.URL, MainPage.class);
        String actualTextActiveButtonOne = mainPage.activeButton.getText();
        String expectedTextFromActiveButtonOne = "Булки";

        //Проверка активности кнопки "Булки" при входе
        MatcherAssert.assertThat("Раздел Булки не активен", actualTextActiveButtonOne, containsString(expectedTextFromActiveButtonOne));

        MainPage mainSausePage = mainPage.clickSauseButton();
        MainPage mainBunPage = mainSausePage.clickBunButton();
        String actualTextActiveButtonTwo = mainBunPage.activeButton.getText();
        String expectedTextFromActiveButtonTwo = "Булки";
        //Проверка активности кнопки "Булки" при переходе из раздела "Соусы"
        MatcherAssert.assertThat("Раздел Булки не активен", actualTextActiveButtonTwo, containsString(expectedTextFromActiveButtonTwo));

    }

    @Test
    public void ClickToSauseButtonTest() {

        MainPage mainPage = open(MainPage.URL, MainPage.class);
        MainPage mainSausePage = mainPage.clickSauseButton();
        //Проверка Отображения надписей "Булки", "Соусы", "Начинки
        String actualTextActiveButton = mainSausePage.activeButton.getText();
        String expectedTextFromActiveButton = "Соусы";
        MatcherAssert.assertThat("Раздел Соусы не активен", actualTextActiveButton, containsString(expectedTextFromActiveButton));
    }

    @Test
    public void ClickToFillingButtonTest() {

        MainPage mainPage = open(MainPage.URL, MainPage.class);
        MainPage mainFillingPage = mainPage.clickFillingButton();
        //Проверка Отображения надписей "Булки", "Соусы", "Начинки
        String actualTextActiveButton = mainFillingPage.activeButton.getText();
        String expectedTextFromActiveButton = "Начинки";
        MatcherAssert.assertThat("Раздел Начинки не активен", actualTextActiveButton, containsString(expectedTextFromActiveButton));
    }

}
