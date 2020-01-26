package Tests.pt.Selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pt.Selenium.WebElement.AjaxFormSubmitPage;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AjaxFormSubmitPageTest {
    private static AjaxFormSubmitPage page2 = AjaxFormSubmitPage.getInstance(); //done

    @AfterAll
    public static void closeDriver(){
        page2.closeDriver();
    }

    @AfterEach
    public void closeDriver2(){
        page2.waitForRefresh();
    }

    @Test
    public void p6_getResult(){
        String result = page2.getResult("null", "null");

        assertEquals("Form submited Successfully!", result);
    }

}