package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.By.*;

public class HomePage {
    private final By CLOSE_COOKIES_BTN = xpath(".//span[@class = 'close']");
    private final By ESTIMATE_BTN = xpath(".//button[contains(@class, 'connect-btn')]");
    private final By LOGO = xpath(".//img[@class = 'top-nav-logo']");

    private Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        assertTrue(baseFunc.isElementOnPage(LOGO), "There is no logo on Home Page");
        LOGGER.info("We are on Home Page");
    }

    public HomePage acceptCookies() {
        LOGGER.info("Accepting cookies");
        baseFunc.click(CLOSE_COOKIES_BTN);
        return this;
    }

    public GetEstimatesModal openEstimatesModal() {
        LOGGER.info("Opening Get Estimates Modal from header");
        baseFunc.click(ESTIMATE_BTN);
        return new GetEstimatesModal(baseFunc);
    }
}
