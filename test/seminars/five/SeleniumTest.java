package seminars.five;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class SeleniumTest {
    WebDriver driver;

    @BeforeEach
    void setup() {
        // System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testSeleniumLinkSearch() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();
        Thread.sleep(2000);
        List<String> links = driver.findElements(By.tagName("a")).stream().map(it -> it.getAttribute("href")).collect(Collectors.toList());
        driver.quit();
        assertTrue(links.contains("https://www.selenium.dev/"));
    }

    @Test
    public void testAuthorization() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);  // Let the user actually see something!
        WebElement loginBox = driver.findElement(By.name("user-name"));
        WebElement passwordBox = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginBox.sendKeys("standard_user");
        passwordBox.sendKeys("secret_sauce");
        loginButton.click();
        Thread.sleep(2000);  // Let the user actually see something!
        WebElement productsLabel = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span"));
        // WebElement productsLabel = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        assertEquals("Products", productsLabel.getText());
        driver.quit();
    }









    /*
    * @Test
    void findSeleniumTest() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();

        List<WebElement> searchUrls = driver.findElements(By.cssSelector("div"));

        boolean isFound = false;
        for (WebElement elem : searchUrls) {
            if (elem.getText().contains("https://www.selenium.dev")) {
                isFound = true;
                break;
            }
        }

        assertTrue(isFound);
        driver.quit();
    }
    * */
}