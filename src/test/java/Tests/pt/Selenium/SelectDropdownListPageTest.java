package Tests.pt.Selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pt.Selenium.WebElement.SelectDropdownListPage;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SelectDropdownListPageTest {
    private static SelectDropdownListPage page4 = SelectDropdownListPage.getInstance(); //done

    @AfterAll
    public static void closeDriver(){
        page4.closeDriver();
    }

    @AfterEach
    public void closeDriver2(){
        page4.waitForRefresh();
    }

    @Test
    public void p4_singleSelectDay(){
        String result = page4.singlePutDay("Monday");

        assertEquals("Day selected :- Monday", result);
    }

    @Test
    public void p4_multiSelectButtonFirstNULL(){
        String result = page4.multiPutCityButtonFirst(new String[]{});

        assertEquals("First selected option is : undefined", result);
    }

    @Test
    public void p4_multiSelectButtonAllNULL(){
        String result = page4.multiPutCityButtonAll(new String[]{});

        assertEquals("Options selected are :", result);
    }

    @Test
    public void p4_multiSelectButtonFirst(){
        String result = page4.multiPutCityButtonFirst(new String[]{"Texas", "California", "Florida"});

        assertEquals("First selected option is : Texas", result);
    }

    @Test
    public void p4_multiSelectButtonAll(){
        String result = page4.multiPutCityButtonAll(new String[]{"Texas", "California", "Florida"});

        assertEquals("Options selected are : Texas,California,Florida", result);
    }

}