package Tests.pt.Selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pt.Selenium.WebElement.BootstrapModalsPage;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BootstrapModalsPageTest {
    private static BootstrapModalsPage page10 = BootstrapModalsPage.getInstance(); //done

    @AfterAll
    public static void closeDriver(){
        page10.closeDriver();
    }

    @AfterEach
    public void closeDriver2(){
        page10.waitForRefresh();
    }

    @Test
    public void openSingleBootstrapAndCheckPageNotReloadAfterClickClose(){
        assertTrue(page10.openSingleModal(true));
    }

    @Test
    public void openSingleBootstrapAndCheckPageReloadAfterClickSave(){
        assertTrue(page10.openSingleModal(false));
    }


}