package Tests.pt.Selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pt.Selenium.WebElement.JavascriptAlertsPage;

import static org.junit.jupiter.api.Assertions.*;

class JavascriptAlertsPageTest {
    private static JavascriptAlertsPage page5 = JavascriptAlertsPage.getInstance(); //done

    @AfterAll
    public static void closeDriver(){
        page5.closeDriver();
    }

    @AfterEach
    public void closeDriver2(){
        page5.waitForRefresh();
    }
    @Test
    public void p5_isFirstAlertPresent(){
        assertTrue(page5.firstAlertIsPresent());
    }

    @Test
    public void p5_firstAlertCheckInfo(){
        String result = page5.firstAlertShow();

        assertEquals("I am an alert box!", result);
    }

    @Test
    public void p5_firstAlertCanAccept(){
        assertTrue(page5.firstAlertClickOK());
    }

    @Test
    public void p5_isSecondAlertPresent(){
        assertTrue(page5.secondAlertIsPresent());
    }

    @Test
    public void p5_secondAlertCheckInfo(){
        String result = page5.secondAlertShow();

        assertEquals("Press a button!", result);
    }

    @Test
    public void p5_secondAlertCanAccept(){
        assertTrue(page5.secondAlertClickOK());
    }

    @Test
    public void p5_isThirdAlertPresent(){
        assertTrue(page5.thirdAlertIsPresent());
    }

    @Test
    public void p5_thirdAlertCheckInfo(){
        String result = page5.thirdAlertShow();

        assertEquals("Please enter your name", result);
    }

    @Test
    public void p5_thirdAlertCanAccept(){
        assertTrue(page5.thirdAlertClickOK());
    }
}