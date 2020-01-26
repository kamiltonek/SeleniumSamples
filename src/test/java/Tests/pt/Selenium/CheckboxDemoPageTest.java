package Tests.pt.Selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pt.Selenium.WebElement.CheckboxDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckboxDemoPageTest {
    private static CheckboxDemo page = CheckboxDemo.getInstance(); //done

    @AfterAll
    public static void closeDriver(){
        page.closeDriver();
    }

    @AfterEach
    public void closeDriver2(){
        page.waitForRefresh();
    }

    @Test
    public void p2_SingleCheckBox(){
        String result = page.checkAndGetResult();

        assertEquals("Success - Check box is checked", result);
    }

    @Test
    public void p2_MultipleCheckBoxCase1(){
        String result = page.checkAndGetResult(true, true, true, true);

        assertEquals("Uncheck All", result);
    }

    @Test
    public void p2_MultipleCheckBoxCase2(){
        String result = page.checkAndGetResult(false, true, true, true);

        assertEquals("Check All", result);
    }

    @Test
    public void p2_SingleCheckBoxAndMultipleCheckBoxCase1(){
        page.checkAndGetResult();
        String result = page.checkAndGetResult(true, true, true, true);

        assertEquals("Uncheck All", result);
    }

    @Test
    public void p2_SingleCheckBoxAndMultipleCheckBoxCase2(){
        page.checkAndGetResult();
        String result = page.checkAndGetResult(false, true, true, true);

        assertEquals("Check All", result);
    }
}