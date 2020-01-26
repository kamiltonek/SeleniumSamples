package Tests.pt.Selenium;

import org.junit.jupiter.api.*;
import pt.Selenium.WebElement.SimpleFormDemoPage;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleFormDemoPageTest {

    private static SimpleFormDemoPage page1 = SimpleFormDemoPage.getInstance(); //done

    @AfterAll
    public static void closeDriver(){
        page1.closeDriver();
    }

    @AfterEach
    public void closeDriver2(){
        page1.waitForRefresh();
    }

    @Test
    public void SimpleFormDemo_SingleInputTest1(){
        String myMessage = "Kamil";
        String result = page1.getResult(myMessage);

        assertEquals(myMessage, result);
    }

    @Test
    public void SimpleFormDemo_SingleInputTest2(){
        String myMessage = "Kamil123456789";
        String result = page1.getResult(myMessage);

        assertEquals(myMessage, result);
    }

    @Test
    public void SimpleFormDemo_DoubleInputTestTwoNumber(){
        String firstValue = "1";
        String secondValue = "3";
        String expected = "4";
        String result = page1.getResult(firstValue, secondValue);

        assertEquals(expected, result);
    }

    @Test
    public void SimpleFormDemo_DoubleInputTestNumberAndString(){
        String firstValue = "1";
        String secondValue = "3abc";
        String expected = "4";
        String result = page1.getResult(firstValue, secondValue);

        assertEquals(expected, result);
    }

    @Test
    public void SimpleFormDemo_DoubleInputTestStringAndString(){
        String firstValue = "abc";
        String secondValue = "cba";
        String expected = "NaN";
        String result = page1.getResult(firstValue, secondValue);

        assertEquals(expected, result);
    }
}