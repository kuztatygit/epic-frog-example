package pages;

import model.EstimateRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.By.*;

public class GetEstimatesModal {
    private final By INPUT_GROUP = xpath(".//div[@class = 'input-group']");
    private final By LABEL = tagName("label");
    private final By INPUT = tagName("input");
    private final By TEXTAREA = tagName("textarea");
    private final By SUBMIT_BTN = xpath(".//fieldset//button");

    private Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public GetEstimatesModal(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        LOGGER.info("Get Estimates modal opened");
    }

    public GetEstimatesModal fillInRequestEstimatesForm(EstimateRequest request) {
        LOGGER.info("Filling in Estimates form");
        List<WebElement> inputBlocks = baseFunc.findElements(INPUT_GROUP);

        assertFalse(inputBlocks.isEmpty(), "Can't find input blocks (fields)");

        for (WebElement we : inputBlocks) {
            if (baseFunc.getText(we, LABEL).startsWith("Name")) baseFunc.type(we, INPUT, request.getName());
            if (baseFunc.getText(we, LABEL).startsWith("Your email")) baseFunc.type(we, INPUT, request.getEmail());
        }

        baseFunc.type(TEXTAREA, request.getDescription());
        return this;
    }

    public void submitForm() {
        LOGGER.info("Submitting form");
        //TODO: Add IP to Captcha's whitelist
        baseFunc.click(SUBMIT_BTN);
        //TODO: BUG-1234: 500 ERROR on submitting form
    }
}
