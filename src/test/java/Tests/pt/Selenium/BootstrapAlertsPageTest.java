package Tests.pt.Selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pt.Selenium.WebElement.BootstrapAlertsPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BootstrapAlertsPageTest {
    private static BootstrapAlertsPage page = BootstrapAlertsPage.getInstance(); //done

    @AfterAll
    public static void closeDriver(){
        page.closeDriver();
    }

    @AfterEach
    public void closeDriver2(){
        page.waitForRefresh();
    }

    @Test
    public void p10_clickAndWaitForResultSuccessAutocloseable(){
        boolean result = page.clickAutocloseableAlert("success");

        assertTrue(result);
    }
    @Test
    public void p10_clickAndWaitForResultWarningAutocloseable(){
        boolean result = page.clickAutocloseableAlert("warning");

        assertTrue(result);
    }
    @Test
    public void p10_clickAndWaitForResultDangerAutocloseable(){
        boolean result = page.clickAutocloseableAlert("danger");

        assertTrue(result);
    }
    @Test
    public void p10_clickAndWaitForResultInfoAutocloseable(){
        boolean result = page.clickAutocloseableAlert("info");

        assertTrue(result);
    }
    @Test
    public void p10_clickAndWaitForResultSuccessNormal(){
        boolean result = page.clickNormalAlert("success");

        assertTrue(result);
    }
    @Test
    public void p10_clickAndWaitForResultWarningNormal(){
        boolean result = page.clickNormalAlert("warning");

        assertTrue(result);
    }
    @Test
    public void p10_clickAndWaitForResultDangerNormal(){
        boolean result = page.clickNormalAlert("danger");

        assertTrue(result);
    }
    @Test
    public void p10_clickAndWaitForResultInfoNormal(){
        boolean result = page.clickNormalAlert("info");

        assertTrue(result);
    }
}