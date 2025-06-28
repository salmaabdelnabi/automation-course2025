package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {

    @Test
    public void checkTitle(){ //Workshop Task #1
        WebDriver driver = new ChromeDriver();
        driver.get("https://duckduckgo.com/");
        Assert.assertEquals(driver.getTitle(),"Google");
        driver.quit();
    }
}
