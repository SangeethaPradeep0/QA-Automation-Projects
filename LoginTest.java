import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void testValidLogin() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("submit"));

        username.sendKeys("student");
        password.sendKeys("Password123");
        loginBtn.click();

        WebElement successMsg = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(successMsg.getText(), "Logged In Successfully");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
