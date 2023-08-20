package praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AllElementsMainPage {
    WebDriver driver = new ChromeDriver();
// Кнопка "Заказать" в верхней части страницы
WebElement orderButtonTop = driver.findElement(By.className("Button_Button__ra12g"));

// Кнопка "Заказать" снизу страницы
     WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button"));

// Кнопка первого вопроса в списке "Вопросы о важном"
WebElement firstQuestion = driver.findElement(By.id("accordion__heading-0"));

// Текст ответа на первый вопрос
    WebElement element = driver.findElement(By.xpath("//*[@id=\"accordion__panel-0\"]/p"));

// Кнопка второго вопроса в списке "Вопросы о важном"
    WebElement secondQuestion = driver.findElement(By.id("accordion__heading-1"));

// Текст ответа на второй вопрос
    WebElement element = driver.findElement(By.xpath("//*[@id=\"accordion__panel-1\"]/p"));





