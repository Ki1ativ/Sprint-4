import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.hamcrest.CoreMatchers.startsWith;

public class AllElementsTest {
    private WebDriver driver;
    @Before
    public void setPropAndStartBrowser() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
    @Test
    public void testWithUpperOrderButton() {
        AllElements orderInformationPage = new AllElements(driver);
        HomePage homePage = new HomePage(driver);
        homePage.clickUpperOrderButton();
        orderInformationPage.creatingAnOrder(
                "Сергей",
                "Петров",
                "Санкт-Петербург, ул. Старая, дом 45, кв. 9",
                "Лубянка",
                "+79662325210",
                "01.10.2010",
                "сутки",
                "чёрный жемчуг",
                "Вжух");
        String expected = "Заказ оформлен";
        String actual = orderInformationPage.getNotificationOfOrderCreation();
        Assert.assertThat("Уведомление о создании заказа не появлиось или заказ не создан", actual, startsWith(expected));
    }
    @Test
    public void estWithLowerOrderButton() {
        AllElements orderInformationPage = new AllElements(driver);
        HomePage homePage = new HomePage(driver);
        homePage.clickLowerOrderButton();
        orderInformationPage.creatingAnOrder(
                "Жанна",
                "Фукина",
                "Москва, ул. Первая, дом 10, кв. 5",
                "Тверская",
                "+79014003692",
                "30.11.2010",
                "пятеро суток",
                "серая безысходность",
                "Будьте, как дома");
        String expected = "Заказ оформлен";
        String actual = orderInformationPage.getNotificationOfOrderCreation();
        Assert.assertThat("Уведомление о создании заказа не появлиось или заказ не создан", actual, startsWith(expected));
    }
    @After
    public void teardown(){
        driver.quit();
    }

}
