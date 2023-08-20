package praktikum.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObjectDropdownFAQTest {
    private WebDriver driver;

    @FindBy(id = "accordion__heading-0")
    private WebElement firstQuestion;

    @FindBy(id = "accordion__heading-1")
    private WebElement secondQuestion;

    @FindBy(xpath = "//*[@id=\"accordion__panel-0\"]/p")
    private WebElement firstAnswer;

    @FindBy(xpath = "//*[@id=\"accordion__panel-1\"]/p")
    private WebElement secondAnswer;

    public PageObjectDropdownFAQTest(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFirstQuestion() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", firstQuestion);
        firstQuestion.click();
    }

    public void clickSecondQuestion() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", secondQuestion);
        secondQuestion.click();
    }

    public String getFirstAnswerText() {
        return firstAnswer.getText();
    }

    public String getSecondAnswerText() {
        return secondAnswer.getText();
    }
}