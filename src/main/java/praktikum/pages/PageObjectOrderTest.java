import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FAQPage {
    private WebDriver driver;

    //Выбираем опцию "Сутки"
            oneDayOption.click();

    // Находим кнопку "Далее" и кликаем на нее
    WebElement nextButtonBottom = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/button"));
            nextButtonBottom.click();

    // Находим чекбокс "Я согласен с условиями использования"
    WebElement agreementCheckbox = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/label/span"));

    // Кликаем на чекбокс
            agreementCheckbox.click();

    // Находим кнопку "Заказать" и кликаем на нее
    WebElement orderButtonTop = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/button"));
            orderButtonTop.click();

    // Ждем, пока страница перейдет на страницу подтверждения заказа
    WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.urlContains("/order-confirmation"));

    // Проверяем, что мы на странице подтверждения заказа
            assert(driver.getCurrentUrl().contains("/order-confirmation"));

            driver.quit();
}
