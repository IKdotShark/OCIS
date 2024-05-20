package example.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class num4 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Null\\ChromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        WebElement navElement = driver.findElement(By.cssSelector("#vector-main-menu-dropdown-checkbox"));
        navElement.click();
        WebElement currentEventsLinkInnavElem = driver.findElement(By.linkText("Current events"));
        currentEventsLinkInnavElem.click();
    }
}
