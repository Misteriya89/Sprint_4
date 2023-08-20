package praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ScooterOrderTestUpButton {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10).getSeconds(), TimeUnit.SECONDS);

        // Находим кнопку "Заказать" вверху страницы и кликаем на нее
        WebElement orderButtonTop = driver.findElement(By.className("Button_Button__ra12g"));
        orderButtonTop.click();

        // Заполняем поле имя
        WebElement nameInput = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input"));
        nameInput.sendKeys("Юлия");

        // Заполняем поле фамилия
        WebElement surnameInput = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input"));
        surnameInput.sendKeys("Федорова");

        // Заполняем поле адрес
        WebElement addressInput = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input"));
        addressInput.sendKeys("г. Москва ул. Минина, д. 2Ж");

        //Находим выпадающий список "Станция метро"
        WebElement metroDropdown = driver.findElement(By.className("select-search"));

       // Кликаем на выпадающий список, чтобы открыть его
        metroDropdown.click();

      // Находим все опции в выпадающем списке
        List<WebElement> options = driver.findElements(By.className("select-search__option"));

      // Ищем нужную опцию и кликаем на нее
        for (WebElement option : options) {
            if (option.getText().equals("Минская")) {
                option.click();
                break;
            }
        }

        // Заполняем поле "Телефон"
        WebElement phoneInput = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input"));
        phoneInput.sendKeys("+79999999999");

        // Находим кнопку "Далее" и кликаем на нее
        WebElement nextButtonTop = driver.findElement(By.className("Button_Middle__1CSJM"));
        nextButtonTop.click();

        // Находим выпадающий список "Когда привезти самокат"
        WebElement deliveryDateDropdown = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input"));

        // Кликаем на выпадающий список
        deliveryDateDropdown.click();

        // Находим элемент с датой 21.08.2023 года
        WebElement date = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[1]"));

        // Кликаем на элемент с датой
        date.click();

        // Находим выпадающий список "Срок аренды"
        WebElement rentalPeriodDropdown = driver.findElement(By.className("Dropdown-placeholder"));

        // Кликаем на выпадающий список
        rentalPeriodDropdown.click();

        // Находим элемент "Сутки"
        WebElement oneDayOption = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]"));

        // Кликаем на элемент "Сутки"
        oneDayOption.click();

        //Находим поле с выбором цвета самоката
        WebElement orderColor = driver.findElement(By.className("Order_Checkboxes__3lWSI"));
        orderColor.click();

        //Находим чек-бокс с цветом "черный жемчуг" и кликаем на него
        WebElement orderBlackColor = driver.findElement(By.className("Checkbox_Label__3wxSf"));
        orderBlackColor.click();

        //Находим поле "Комментарий для курьера" и заполняем его
        WebElement commentForCourier = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input"));
        commentForCourier.sendKeys("Звонить много раз");;

        //Находим кнопку "Заказать" кликаем на нее
        WebElement orderButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]"));
        orderButton.click();

        //Находим кнопку "Да" и кликаем на нее в окне подтверждения заказа
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]"));
        submitButton.click();

        // Проверяем, что появилось всплывающее окно с сообщением об успешном создании заказа
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_ModalHeader__3FDaJ")));
        String messageText = successMessage.getText();
        if (messageText.equals("Заказ оформлен")) {
            System.out.println("Заказ успешно создан!");
        } else {
            System.out.println("Произошла ошибка при создании заказа");
        }

        // Закрываем браузер
        driver.quit();
    }
}