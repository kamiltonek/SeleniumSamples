package Tests.pt.Selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pt.Selenium.WebElement.BootstrapProgressBarPage;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BootstrapProgressBarPageTest {
    private static BootstrapProgressBarPage page2 = BootstrapProgressBarPage.getInstance(); //done

    @AfterAll
    public static void closeDriver(){
        page2.closeDriver();
    }

    @AfterEach
    public void closeDriver2(){
        page2.waitForRefresh();
    }

    @Test
    public void p9_clickAndDownload(){
        boolean result = page2.clickAndDownload();

        assertTrue(result);
    }

}