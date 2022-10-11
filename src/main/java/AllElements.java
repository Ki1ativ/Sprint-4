import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AllElements {
    private WebDriver driver;
    //Имя
    private By firstNameField = By.xpath("//input[@placeholder='* Имя']");
    //Фамилия
    private By secondNameField = By.xpath("//input[@placeholder='* Фамилия']");
    //Адрес
    private By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //Станция метро
    private By metroStationField = By.xpath("//input[@placeholder='* Станция метро']");
    //Телефон
    private By phoneNumberField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private By nextButton = By.xpath("//button[text()='Далее']");
    //Когда привезти самокат
    private By dateDeliveryField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //Срок аренды
    private By rentalPeriodField = By.xpath("//div[text()='* Срок аренды']");
    //Выбор срока аренды из выпадайки
    private String xpathRentalPeriodDropDown = "//div[@class ='Dropdown-option' and text()='%s']";
    //Выбор цвета самоката
    private String xpathScooterColorCheckBox = "//label[text()='%s']/input";
    //Комментарий для курьера
    private By commentForDeliverymanField = By.xpath("//input[@placeholder='Комментарий для курьера']");
    //Кнопка "Заказать"
    private By orderButton = By.xpath("(//button[text()='Заказать'])[2]");
    //Кнопка "Да" в окне подтверждения заказа
    private  By yesButton = By.xpath("//button[text()='Да']");
    //Сообщение об успешном создании заказа
    public By notificationOfOrderCreation = By.xpath("//div[text()='Заказ оформлен']");
    public AllElements(WebDriver driver) {
        this.driver = driver;
    }
    public void setFirstName (String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void setSecondName (String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
    }
    public void setAddress (String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    public void clickNextButton () {
        driver.findElement(nextButton).click();
    }
    public void setMetroStation(String metroStation) {
        driver.findElement(metroStationField).sendKeys(metroStation + Keys.ARROW_DOWN + Keys.ENTER);
    }
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }
    public void setDateDelivery(String dateDelivery) {
        driver.findElement(dateDeliveryField).sendKeys(dateDelivery + Keys.ENTER);
    }
    public void setRentalPeriod(String rentalPeriod) {
        driver.findElement(rentalPeriodField).click();
        driver.findElement(By.xpath(String.format(xpathRentalPeriodDropDown, rentalPeriod))).click();
    }
    public void setScooterColor(String scooterColor) {
        driver.findElement(By.xpath(String.format(xpathScooterColorCheckBox, scooterColor))).click();
    }
    public void setCommentForDeliveryman(String commentForDeliveryman){
        driver.findElement(commentForDeliverymanField).sendKeys(commentForDeliveryman);
    }
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }
    public String getNotificationOfOrderCreation() {
        return driver.findElement(notificationOfOrderCreation).getText();
    }
    public void creatingAnOrder (String firstName, String secondName, String address, String metroStation, String phoneNumber,
                                 String dateDelivery, String rentalPeriod, String scooterColor, String commentForDeliveryman) {
        setFirstName(firstName);
        setSecondName(secondName);
        setAddress(address);
        setMetroStation(metroStation);
        setPhoneNumber(phoneNumber);
        clickNextButton();
        setDateDelivery(dateDelivery);
        setRentalPeriod(rentalPeriod);
        setScooterColor(scooterColor);
        setCommentForDeliveryman(commentForDeliveryman);
        clickOrderButton();
        clickYesButton();
    }

}
