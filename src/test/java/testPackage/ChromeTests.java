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
public class ChromeTests {
    WebDriver chromeDriver;
    By duckDuckGoSearchBoxLocator = By.id("searchbox_input");

    @BeforeMethod
    public void beforeMethod(){
        chromeDriver = new ChromeDriver();
    }

    @AfterMethod
    public void afterMethod(){
        chromeDriver.quit();
    }

    public void assertPageTitle(){ //Workshop Task #1
        chromeDriver.navigate().to("https://duckduckgo.com/");
        Assert.assertEquals(chromeDriver.getTitle(),"Google");
    }

    public void assertThatLogoIsDisplayed(){ //Workshop Task #2
        chromeDriver.navigate().to("https://duckduckgo.com/");
        By duckDuckGoLogoLocator = By.xpath("//div[contains(@class,'Desktop')]//img");
        Assert.assertTrue(chromeDriver.findElement(duckDuckGoLogoLocator).isDisplayed());
    }

    public void searchForSeleniumWebDriverAndAssertLink(){ //Workshop Task #3
        chromeDriver.navigate().to("https://duckduckgo.com/");

        var searchBox = chromeDriver.findElement(duckDuckGoSearchBoxLocator);
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();

        By firstSearchResultLinkLocator = By.xpath("(//a[@data-testid='result-extras-url-link'])[1]");

        WebDriverWait wait = new WebDriverWait(chromeDriver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstSearchResultLinkLocator));

        Assert.assertEquals(chromeDriver.findElement(firstSearchResultLinkLocator).getAttribute("href"),
                "https://www.selenium.dev/documentation/webdriver/");
    }

    public void searchForCucumberIOAndAssertLink(){ //Workshop Task #5
        chromeDriver.navigate().to("https://duckduckgo.com/");

        var searchBox = chromeDriver.findElement(duckDuckGoSearchBoxLocator);
        searchBox.sendKeys("Cucumber IO");
        searchBox.submit();

        By secondSearchResultLinkLocator = By.xpath("(//a[@data-testid='result-extras-url-link'])[2]");

        WebDriverWait wait = new WebDriverWait(chromeDriver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondSearchResultLinkLocator));

        Assert.assertTrue(chromeDriver.findElement(secondSearchResultLinkLocator).getAttribute("href")
                .contains("https://www.linkedin.com"));
    }
}
