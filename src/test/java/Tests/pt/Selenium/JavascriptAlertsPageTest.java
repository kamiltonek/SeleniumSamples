package Tests.pt.Selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pt.Selenium.WebElement.JavascriptAlertsPage;

import static org.junit.jupiter.api.Assertions.*;

class JavascriptAlertsPageTest {
    private static JavascriptAlertsPage page = JavascriptAlertsPage.getInstance(); //done

    @AfterAll
    public static void closeDriver(){
        page.closeDriver();
    }

    @AfterEach
    public void closeDriver2(){
        page.waitForRefresh();
    }
    @Test
    public void p5_isFirstAlertPresent(){
        assertTrue(page.firstAlertIsPresent());
    }

    @Test
    public void p5_firstAlertCheckInfo(){
        String result = page.firstAlertShow();

        assertEquals("I am an alert box!", result);
    }

    @Test
    public void p5_firstAlertCanAccept(){
        assertTrue(page.firstAlertClickOK());
    }

    @Test
    public void p5_isSecondAlertPresent(){
        assertTrue(page.secondAlertIsPresent());
    }

    @Test
    public void p5_secondAlertCheckInfo(){
        String result = page.secondAlertShow();

        assertEquals("Press a button!", result);
    }

    @Test
    public void p5_secondAlertCanAccept(){
        assertTrue(page.secondAlertClickOK());
    }

    @Test
    public void p5_isThirdAlertPresent(){
        assertTrue(page.thirdAlertIsPresent());
    }

    @Test
    public void p5_thirdAlertCheckInfo(){
        String result = page.thirdAlertShow();

        assertEquals("Please enter your name", result);
    }

    @Test
    public void p5_thirdAlertCanAccept(){
        assertTrue(page.thirdAlertClickOK());
    }
}