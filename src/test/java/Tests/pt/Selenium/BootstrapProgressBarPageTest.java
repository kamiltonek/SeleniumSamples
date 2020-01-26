package Tests.pt.Selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pt.Selenium.WebElement.BootstrapProgressBarPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BootstrapProgressBarPageTest {
    private static BootstrapProgressBarPage page = BootstrapProgressBarPage.getInstance(); //done

    @AfterAll
    public static void closeDriver(){
        page.closeDriver();
    }

    @AfterEach
    public void closeDriver2(){
        page.waitForRefresh();
    }

    @Test
    public void p9_clickAndDownload(){
        boolean result = page.clickAndDownload();

        assertTrue(result);
    }

}