package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class TestClass {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void AfterMethod(){
        driver.quit();
    }

    public void checkTitle(){ //Workshop Task #1
        driver.get("https://duckduckgo.com/");
        Assert.assertEquals(driver.getTitle(),"Google");
    }

    public void checkLogo(){ //Workshop Task #2
        driver.get("https://duckduckgo.com/");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/article/div[1]/div[1]/div[2]/div/header/div/section[1]/a/img")).isDisplayed());
    }
}
