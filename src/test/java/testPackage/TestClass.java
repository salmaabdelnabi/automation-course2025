package testPackage;

import org.openqa.selenium.By;
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

    @Test
    public void checkLogo(){ //Workshop Task #2
        WebDriver driver = new ChromeDriver();
        driver.get("https://duckduckgo.com/");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/article/div[1]/div[1]/div[2]/div/header/div/section[1]/a/img")).isDisplayed());
        driver.quit();
    }
}
