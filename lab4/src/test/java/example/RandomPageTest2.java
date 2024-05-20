package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class RandomPageTest2 {
    private WebDriver driver;
    private MainPage wikipediaHomePage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");

        driver = new ChromeDriver();
        wikipediaHomePage = new MainPage(driver);
    }

    @Test
    @Parameters({"numberOfPages"})
    public void testRandomPages(int numberOfPages) {
        wikipediaHomePage.open();

        for (int i = 0; i < numberOfPages; i++) {
            RandomWikiPage randomPage = wikipediaHomePage.navigateToRandomArticle();

            System.out.println("\n");
            System.out.println("URL: " + randomPage.getPageUrl());
            System.out.println("Заголовок: " + randomPage.getPageTitle());
            System.out.println("Источники: ");
            for (WebElement source : randomPage.getPageSources()) {
                System.out.println("- " + source.getText() + ": " + source.getAttribute("href"));
            }

            randomPage.goBack();
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}