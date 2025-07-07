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
    public void afterMethod(){
        driver.quit();
    }

    public void assertPageTitle(){ //Workshop Task #1
        driver.navigate().to("https://duckduckgo.com/");
        Assert.assertEquals(driver.getTitle(),"Google");
    }

    public void assertThatLogoIsDisplayed(){ //Workshop Task #2
        driver.navigate().to("https://duckduckgo.com/");
        By duckDuckGoLogoLocator = By.xpath("//div[contains(@class,'Desktop')]//img");
        Assert.assertTrue(driver.findElement(duckDuckGoLogoLocator).isDisplayed());
    }

    public void searchForSeleniumWebDriverAndAssertLink(){ //Workshop Task #3
        driver.navigate().to("https://duckduckgo.com/");

        By searchBoxLocator = By.id("searchbox_input");
        var searchBox = driver.findElement(searchBoxLocator);
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();

        By firstSearchResultLocator = By.xpath("(//a[@data-testid='result-extras-url-link'])[1]");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstSearchResultLocator));

        Assert.assertEquals(driver.findElement(firstSearchResultLocator).getAttribute("href"),
                "https://www.selenium.dev/documentation/webdriver/");
    }
}
