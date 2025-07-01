package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

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

    public void searchForSeleniumWebDriverAndAssertLink(){ //Workshop Task #3
        driver.navigate().to("https://duckduckgo.com/");
        var searchBox = driver.findElement(By.className("searchbox_input__rnFzM"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"r1-0\"]/div[2]/div/div/a")));

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"r1-0\"]/div[2]/div/div/a")).getAttribute("href"),
                "https://www.selenium.dev/documentation/webdriver/");
    }
}
