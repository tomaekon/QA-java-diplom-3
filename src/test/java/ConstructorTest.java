import com.BrowserProperty;
import com.codeborne.selenide.Browser;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.burger.po.MainPage;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.CoreMatchers.containsString;

public class ConstructorTest extends BrowserProperty {

    @Before
    public void startUp() {
        browserPropertySetUp("chrome");
        clearBrowserCookies();
    }

    @After
    public void tearDown() {
        closeWindow();
        closeWebDriver();
    }

    @Test
    @DisplayName("Проверка перехода на вкладку Булки")
    public void ClickToBunButtonTest() {

        MainPage mainPage = open(MainPage.URL, MainPage.class);
        String actualTextActiveButtonOne = mainPage.getTextActiveButton();
        String expectedTextFromActiveButton= "Булки";
        Assert.assertEquals("Раздел Булки не активен", actualTextActiveButtonOne, expectedTextFromActiveButton);

        MainPage mainSausePage = mainPage.clickSauseButton();
        MainPage mainBunPage = mainSausePage.clickBunButton();
        String actualTextActiveButtonTwo = mainBunPage.getTextActiveButton();
        Assert.assertEquals("Раздел Булки не активен", actualTextActiveButtonTwo, expectedTextFromActiveButton);
    }

    @Test
    @DisplayName("Проверка перехода на вкладку Соусы")
    public void ClickToSauseButtonTest() {

        MainPage mainPage = open(MainPage.URL, MainPage.class);
        MainPage mainSausePage = mainPage.clickSauseButton();
        String actualTextActiveButton = mainSausePage.getTextActiveButton();
        String expectedTextFromActiveButton = "Соусы";
        Assert.assertEquals("Раздел Соусы не активен", actualTextActiveButton, expectedTextFromActiveButton);
    }

    @Test
    @DisplayName("Проверка перехода на вкладку Начинки")
    public void ClickToFillingButtonTest() {

        MainPage mainPage = open(MainPage.URL, MainPage.class);
        MainPage mainFillingPage = mainPage.clickFillingButton();
        String actualTextActiveButton = mainFillingPage.getTextActiveButton();
        String expectedTextFromActiveButton = "Начинки";
        Assert.assertEquals("Раздел Начинки не активен", actualTextActiveButton, expectedTextFromActiveButton);
    }
}
