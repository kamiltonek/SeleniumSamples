package Tests.pt.Selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pt.Selenium.WebElement.CheckboxDemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckboxDemoPageTest {
    private static CheckboxDemo page2 = CheckboxDemo.getInstance(); //done

    @AfterAll
    public static void closeDriver(){
        page2.closeDriver();
    }

    @AfterEach
    public void closeDriver2(){
        page2.waitForRefresh();
    }

    @Test
    public void p2_SingleCheckBox(){
        String result = page2.checkAndGetResult();

        assertEquals("Success - Check box is checked", result);
    }

    @Test
    public void p2_MultipleCheckBoxCase1(){
        String result = page2.checkAndGetResult(true, true, true, true);

        assertEquals("Uncheck All", result);
    }

    @Test
    public void p2_MultipleCheckBoxCase2(){
        String result = page2.checkAndGetResult(false, true, true, true);

        assertEquals("Check All", result);
    }

    @Test
    public void p2_SingleCheckBoxAndMultipleCheckBoxCase1(){
        page2.checkAndGetResult();
        String result = page2.checkAndGetResult(true, true, true, true);

        assertEquals("Uncheck All", result);
    }

    @Test
    public void p2_SingleCheckBoxAndMultipleCheckBoxCase2(){
        page2.checkAndGetResult();
        String result = page2.checkAndGetResult(false, true, true, true);

        assertEquals("Check All", result);
    }
}