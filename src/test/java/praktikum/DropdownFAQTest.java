import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownFAQTest {

    @Test
    public void testFirstQuestion() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        // Скроллим страницу до первого вопроса и нажимаем на него
        WebElement firstQuestion = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", firstQuestion);
        firstQuestion.click();

        // Находим текст ответа на первый вопрос
        WebElement element = driver.findElement(By.xpath("//*[@id=\"accordion__panel-0\"]/p"));

        // Сравниваем текст ответа с текстом, который должен быть написан
        String expectedText = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actualText = element.getText();
        assert actualText.equals(expectedText) : "Text does not match";

        driver.quit();
    }


    @Test
    public void testSecondQuestion() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        // Скроллим страницу до второго вопроса и нажимаем на него
        WebElement secondQuestion = driver.findElement(By.id("accordion__heading-1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", secondQuestion);
        secondQuestion.click();

        // Находим текст ответа на второй вопрос
        WebElement element = driver.findElement(By.xpath("//*[@id=\"accordion__panel-1\"]/p"));

        // Сравниваем текст ответа с текстом, который должен быть написан
        String expectedText = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        String actualText = element.getText();
        assert actualText.equals(expectedText) : "Text does not match";

        driver.quit();
    }
}