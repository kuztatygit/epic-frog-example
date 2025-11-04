package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseFunc {
    private Logger LOGGER = LogManager.getLogger(this.getClass());
    private WebDriver driver;
    private WebDriverWait wait;

    public BaseFunc() {
        LOGGER.info("Opening Browser Window");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void openUrl(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) url = "http://" + url;
        driver.get(url);
    }

    public HomePage openHomePage() {
        LOGGER.info("Going to Home Page");
        openUrl("epicfrog.com");
        return new HomePage(this);
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement findElement(WebElement parent, By child) {
        return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parent, child));
    }

    public List<WebElement> findElements(By locator) {
        return  driver.findElements(locator);
    }

    public boolean isElementOnPage(By locator) {
        try {
            findElement(locator);
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public String getText(WebElement parent, By child) {
        return findElement(parent, child).getText();
    }

    public void type(By locator, String text) {
        type(findElement(locator), text);
    }

    public void type(WebElement input, String text) {
        input.clear();
        input.sendKeys(text);
    }

    public void type(WebElement parent, By child, String text) {
        type(findElement(parent, child), text);
    }

    public void closeBrowser() {
        LOGGER.info("Closing Browser Window");
        if (driver != null) {
            driver.quit();
        }
    }
}
