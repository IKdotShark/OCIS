package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.time.Duration;

public class RandomPageTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Null\\ChromeDriver\\chromedriver.exe");

        driver = new ChromeDriver();
    }

    @Test
    @Parameters({"numberOfPages"})
    public void testRandomPages(int numberOfPages) {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        for (int i = 0; i < numberOfPages; i++) {
            WebElement navElement = driver.findElement(By.cssSelector("#vector-main-menu-dropdown-checkbox"));
            navElement.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
            WebElement randomLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Random article")));

            randomLink.click();

            String pageUrl = driver.getCurrentUrl();
            String pageTitle = driver.getTitle();
            List<WebElement> sources = driver.findElements(By.xpath("//div[@id='mw-content-text']//a[@class='external text']"));
            System.out.println("\n");
            System.out.println("URL: " + pageUrl);
            System.out.println("Заголовок: " + pageTitle);
            System.out.println("Источники: ");
            for (WebElement sourse : sources) {
                System.out.println("- " + sourse.getText() + ": " + sourse.getAttribute("href"));
            }

            driver.navigate().back();
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}