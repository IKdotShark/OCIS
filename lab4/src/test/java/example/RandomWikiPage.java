package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RandomWikiPage {
    private WebDriver driver;

    RandomWikiPage(WebDriver driver) {
        this.driver = driver;
    }

    String getPageUrl() {
        return driver.getCurrentUrl();
    }

    String getPageTitle() {
        return driver.getTitle();
    }

    List<WebElement> getPageSources() {
        return driver.findElements(By.xpath("//div[@id='mw-content-text']//a[@class='external text']"));
    }

    void goBack() {
        driver.navigate().back();
    }
}