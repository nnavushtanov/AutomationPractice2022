import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class Automation {
    WebDriver driver;

    int addButtons = 3;
    int removeButtons = 2;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void shutdown() throws InterruptedException {
        Thread.sleep(3000L);
        driver.quit();
    }

    @Test
//    void firstTest() {
//        Actions actions = new Actions(driver);
//        driver.get("https://magento.softwaretestingboard.com");
//        driver.findElement(By.linkText("Sale")).click();
//        driver.findElement(By.linkText("Jackets")).click();
//        WebElement firstItem = driver.findElement(By.xpath("//div[@class='columns']/div/div[3]/ol/li/div"));
//        actions.moveToElement(firstItem).perform();
//        driver.findElement(By.xpath("//div[@aria-label='XL']")).click();
//        driver.findElement(By.xpath("//div[@aria-label='Blue']")).click();
//        driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
//
//        driver.findElement(By.className("showcart")).click();
//        driver.findElement(By.id("top-cart-btn-checkout")).click();
//    }
//    void first() {
//        driver.get("https://the-internet.herokuapp.com/basic_auth");
//        String username = "admin";
//        String pass = "admin";
//        String url = driver.getCurrentUrl().replaceAll("https://", "");
//        String URL = "https://" + username  + ":" + pass + "@" + url;
//        driver.get(URL);
//        String congrats = driver.findElement(By.xpath("//div[@class='example']/p")).getText();
//        Assertions.assertEquals(congrats.trim(), "Congratulations! You must have the proper credentials.");
//    }

    void addElement() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        for (int i = 0; i < addButtons; i++) {
            driver.findElement(By.tagName("button")).click();
        }
        int elm = driver.findElements(By.xpath("*//div[@id='elements']/button")).size();
        Assertions.assertEquals(elm , addButtons);
    }

    @Test
    void removeElement() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        for (int i = 0; i < addButtons; i++) {
            driver.findElement(By.tagName("button")).click();
        }
        for (int i = 0; i < removeButtons; i++) {
            driver.findElement(By.xpath("//*[text()='Delete']")).click();
        }
        int elm = driver.findElements(By.xpath("*//div[@id='elements']/button")).size();
        Assertions.assertEquals(elm , addButtons - removeButtons);
    }
}
