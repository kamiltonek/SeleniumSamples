package Tests.pt.Selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pt.Selenium.WebElement.JQueryDownloadProgressBarsPage;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JQueryDownloadProgressBarsPageTest {
    private static JQueryDownloadProgressBarsPage page2 = JQueryDownloadProgressBarsPage.getInstance(); //done

    @AfterAll
    public static void closeDriver(){
        page2.closeDriver();
    }

    @AfterEach
    public void closeDriver2(){
        page2.waitForRefresh();
    }

    @Test
    public void p7_downloadResult(){
        String result = page2.startDownload();

        assertEquals("Close", result);
    }
}