import model.EstimateRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pages.BaseFunc;

public class ContactFormTests {
    private Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void requestEstimatesCheck() {
        LOGGER.info("This test will check Estimates Requesting process happy path");
        baseFunc.openHomePage()
                .acceptCookies()
                .openEstimatesModal()
                .fillInRequestEstimatesForm(new EstimateRequest(true))
                .submitForm();
    }

    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }
}