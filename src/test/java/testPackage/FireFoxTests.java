package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class FireFoxTests {
    WebDriver fireFoxDriver;
    By duckDuckGoSearchBoxLocator = By.id("searchbox_input");

    @BeforeMethod
    public void beforeMethod(){
        fireFoxDriver = new FirefoxDriver();
    }

    @AfterMethod
    public void afterMethod(){
        fireFoxDriver.quit();
    }

    public void searchForTestNGAssertFourthResultText(){ //Workshop Task #4
        fireFoxDriver.navigate().to("https://duckduckgo.com/");

        var searchBox = fireFoxDriver.findElement(duckDuckGoSearchBoxLocator);
        searchBox.sendKeys("TestNG");
        searchBox.submit();

        By fourthSearchResultTextLocator = By.xpath("(//a[@data-testid='result-title-a'])[4]/span");

        WebDriverWait wait = new WebDriverWait(fireFoxDriver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fourthSearchResultTextLocator));

        Assert.assertEquals(fireFoxDriver.findElement(fourthSearchResultTextLocator).getText(),
                "TestNG Tutorial");

    }
}
