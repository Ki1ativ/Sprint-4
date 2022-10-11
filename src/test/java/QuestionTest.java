import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;


public class QuestionTest {
    private WebDriver driver;
    @Before
    public void setPropAndStartBrowser() {

        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    @Test
    public void checkHowMuchDoesItCost() {
        HomePage homePage = new HomePage(driver);
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actual = homePage.getHowMuchDoesItCostAnswer();
        assertEquals("Текст ответа на совпадает", expected, actual);
    }
    @Test
    public void checkWantSeveralScootersAtOnce() {
        HomePage homePage = new HomePage(driver);
        String expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        String actual = homePage.getWantSeveralScootersAtOnceAnswer();
        assertEquals("Текст ответа не совпадает", expected, actual);
    }
    @Test
    public void checkHowRentalTimeCalculated() {
        HomePage homePage = new HomePage(driver);
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        String actual = homePage.getHowRentalTimeCalculatedAnswer();
        assertEquals("Текст ответа не совпадает", expected, actual);
    }
    @Test
    public void checkPossibleToOrderScooterToday() {
        HomePage homePage = new HomePage(driver);
        String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        String actual = homePage.getPossibleToOrderScooterToday();
        assertEquals("Текст ответа не совпадает", expected, actual);
    }
    @Test
    public void checkPossibleToExtendOrderOrReturnEarlier() {
        HomePage homePage = new HomePage(driver);
        String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        String actual = homePage.getPossibleToExtendOrderOrReturnEarlier();
        assertEquals("Текст ответа не совпадает", expected, actual);
    }
    @Test
    public void checkChargingAlongWithScooter() {
        HomePage homePage = new HomePage(driver);
        String expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        String actual = homePage.getChargingAlongWithScooter();
        assertEquals("Текст ответа не совпадает", expected, actual);
    }
    @Test
    public void checkPossibleToCancelOrder() {
        HomePage homePage = new HomePage(driver);
        String expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        String actual = homePage.getPossibleToCancelOrder();
        assertEquals("Текст ответа не совпадает", expected, actual);
    }
    @Test
    public void checkBringScooterBeyondMKAD() {
        HomePage homePage = new HomePage(driver);
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        String actual = homePage.getBringScooterBeyondMKAD();
        assertEquals("Текст ответа не совпадает", expected, actual);
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
