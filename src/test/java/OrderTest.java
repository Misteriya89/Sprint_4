import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.MainPage;
import pages.OrderPage;

@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver driver;
    private final String orderButton;
    private final String userName;
    private final String userSurname;
    private final String dateRental;
    private final String userComment;
    private  final String scooterColor;

    public OrderTest(String orderButton, String userName, String userSurname, String dateRental, String userComment, String scooterColor){
        this.orderButton = orderButton;
        this.userName = userName;
        this.userSurname = userSurname;
        this.dateRental = dateRental;
        this.userComment = userComment;
        this.scooterColor = scooterColor;

    }

    @Parameterized.Parameters
    public static Object[][] getUserData(){
        return new Object[][]{
                {"Верхняя кнопка", "Юлия", "Федорова", "26.08.2023", "Поторопись-ка!", "Черный"},
                {"Нижняя кнопка", "Алёна", "Куликова", "28.09.2023", "Хой!" , "Серый"},
        };
    }

    @Test
    public void scooterOrderViaFirefoxTest() {
        System.setProperty(
                "webdriver.gecko.driver",
                "C:\\WebDriver\\bin\\geckodriver.exe"
        );
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnOrderButton(orderButton);
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.enteringPersonalUserData(userName, userSurname, "Минская,2Ж", "88888888888");
        objOrderPage.enterFieldsForRent(dateRental, scooterColor, userComment);
        objOrderPage.clickYes();
        Assert.assertEquals("Текст 'Заказ оформлен' на странице не найден.",1, objOrderPage.getCountTitleOfSuccessfulOrder());
    }

    @Test
    public void scooterOrderViaChromeTest() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\WebDriver\\bin\\chromedriver.exe"
        );
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnOrderButton(orderButton);
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.enteringPersonalUserData(userName, userSurname, "Минская,2Ж", "88888888888");
        objOrderPage.enterFieldsForRent(dateRental, scooterColor, userComment);
        objOrderPage.clickYes();
        Assert.assertEquals("Текст 'Заказ оформлен' на странице не найден.",1, objOrderPage.getCountTitleOfSuccessfulOrder());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
