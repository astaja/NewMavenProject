import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTest {

    Public static Webdirver driver;

    @Test
    public void openUrl() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.skelbiu.lt/");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click(); // agree to Cookies

        WebElement searchInput = driver.findElement(By.id("searchKeyword"));
        searchInput.sendKeys("meškiukas");                    // typing custom search keyword
        driver.findElement(By.id("searchButton")).click();                        // click the searh icon in the search bar
        driver.quit();

    }

    @BeforeClass
    public void BeforeClass () {

    }

}
