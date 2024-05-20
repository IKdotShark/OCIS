package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;

    MainPage(WebDriver driver) {
        this.driver = driver;
    }

    void open() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
    }

    RandomWikiPage navigateToRandomArticle() {
        WebElement navElement = driver.findElement(By.cssSelector("body > div.vector-header-container > header > div.vector-header-start > nav"));
        navElement.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement randomLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Random article")));
        randomLink.click();
        return new RandomWikiPage(driver);
    }
}