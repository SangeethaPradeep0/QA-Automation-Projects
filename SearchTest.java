import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest {
    @DataProvider(name = "searchData")
    public Object[][] getData() {
        return new Object[][] {
            {"Selenium"},
            {"TestNG"},
            {"Automation"}
        };
    }

    @Test(dataProvider = "searchData")
    public void searchGoogle(String keyword) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(keyword);
        searchBox.submit();
        System.out.println("Searched for: " + keyword);
        driver.quit();
    }
}
