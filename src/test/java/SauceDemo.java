import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class SauceDemo {
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
    public void buyItem1() {  //  Negative
        WebElement searchButton = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        searchButton.click();
        WebElement searchIcon = driver.findElement(By.id("shopping_cart_container"));
        searchIcon.click();
        WebElement searchCheckout = driver.findElement(By.id("checkout"));
        searchCheckout.click();
        WebElement searchName = driver.findElement(By.id("first-name"));
        searchName.sendKeys("");
        WebElement searchLastName = driver.findElement(By.id("last-name"));
        searchLastName.sendKeys("");
        WebElement searchZip = driver.findElement(By.id("postal-code"));
        searchZip.sendKeys("");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement searchContinue = driver.findElement(By.id("continue"));
        searchContinue.click();
        WebElement searchFinish = driver.findElement(By.id("finish"));
        searchFinish.click();
    }
    @Test
    public void buyItem2() {  //  Positive
        WebElement searchButton = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        searchButton.click();
        WebElement searchIcon = driver.findElement(By.id("shopping_cart_container"));
        searchIcon.click();
        WebElement searchCheckout = driver.findElement(By.id("checkout"));
        searchCheckout.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement searchName = driver.findElement(By.id("first-name"));
        searchName.sendKeys("Human");
        WebElement searchLastName = driver.findElement(By.id("last-name"));
        searchLastName.sendKeys("Being");
        WebElement searchZip = driver.findElement(By.id("postal-code"));
        searchZip.sendKeys("66666");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement searchContinue = driver.findElement(By.id("continue"));
        searchContinue.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement searchFinish = driver.findElement(By.id("finish"));
        searchFinish.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement searchBack = driver.findElement(By.id("back-to-products"));
        searchBack.click();
    }
    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }
    @BeforeMethod
    public void afterMethod() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("reset_sidebar_link")).click();
        driver.findElement(By.id("react-burger-cross-btn")).click();
    }
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximizes the opened window
        logIn();
    }
    @AfterClass
    public void afterClass() {
           driver.quit();
    }
}
