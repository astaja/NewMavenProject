import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SauceDemo2 {
    public static WebDriver driver;

    public void logIn() { // login is NOT a test =)
        driver.get("https://www.saucedemo.com/");
        WebElement searchInput = driver.findElement(By.id("user-name"));
        searchInput.sendKeys("standard_user");
        WebElement searchInput2 = driver.findElement(By.id("password"));
        searchInput2.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void selectAllItemsTest() { // Selects all items and puts into cart
        WebElement inventory = driver.findElement(By.className("inventory_list"));
        List<WebElement> inventoryItems = inventory.findElements(By.className("inventory_item"));
        for (int i = 0; i < inventoryItems.size(); i++) {
            inventoryItems.get(i).findElement(By.tagName("button")).click();
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @BeforeMethod
    public void afterMethod() {

    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximizes the opened window
        logIn();
    }

    @AfterClass
    public void afterClass() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.quit();
    }
}

