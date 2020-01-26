package Tests.pt.Selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pt.Selenium.WebElement.BootstrapAlertsPage;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BootstrapAlertsPageTest {
    private static BootstrapAlertsPage page10 = BootstrapAlertsPage.getInstance(); //done

    @AfterAll
    public static void closeDriver(){
        page10.closeDriver();
    }

    @AfterEach
    public void closeDriver2(){
        page10.waitForRefresh();
    }

    @Test
    public void p10_clickAndWaitForResultSuccessAutocloseable(){
        boolean result = page10.clickAutocloseableAlert("success");

        assertTrue(result);
    }
    @Test
    public void p10_clickAndWaitForResultWarningAutocloseable(){
        boolean result = page10.clickAutocloseableAlert("warning");

        assertTrue(result);
    }
    @Test
    public void p10_clickAndWaitForResultDangerAutocloseable(){
        boolean result = page10.clickAutocloseableAlert("danger");

        assertTrue(result);
    }
    @Test
    public void p10_clickAndWaitForResultInfoAutocloseable(){
        boolean result = page10.clickAutocloseableAlert("info");

        assertTrue(result);
    }
    @Test
    public void p10_clickAndWaitForResultSuccessNormal(){
        boolean result = page10.clickNormalAlert("success");

        assertTrue(result);
    }
    @Test
    public void p10_clickAndWaitForResultWarningNormal(){
        boolean result = page10.clickNormalAlert("warning");

        assertTrue(result);
    }
    @Test
    public void p10_clickAndWaitForResultDangerNormal(){
        boolean result = page10.clickNormalAlert("danger");

        assertTrue(result);
    }
    @Test
    public void p10_clickAndWaitForResultInfoNormal(){
        boolean result = page10.clickNormalAlert("info");

        assertTrue(result);
    }
}