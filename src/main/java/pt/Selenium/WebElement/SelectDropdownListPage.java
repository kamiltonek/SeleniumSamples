package pt.Selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

//Input Forms --> Select Dropdown List
public class SelectDropdownListPage extends BasicPage {
    private static SelectDropdownListPage instance;

    private WebElement singleSelect;
    By singleResult = By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[2]/p[2]");

    private WebElement multiSelect;
    private WebElement multiButtonFirst;
    private WebElement multiButtonAll;
    By multiResult = By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/p[2]");

    private SelectDropdownListPage(){
        webDriver.get(TEST_PAGE + "basic-select-dropdown-demo.html");
        Init();
    }

    private void Init(){
        singleSelect = webDriver.findElement(By.id("select-demo"));

        multiSelect = webDriver.findElement(By.id("multi-select"));
        multiButtonFirst = webDriver.findElement(By.id("printMe"));
        multiButtonAll = webDriver.findElement(By.id("printAll"));
    }

    public static SelectDropdownListPage getInstance() {
        if(instance == null){
            instance = new SelectDropdownListPage();
        }
        return instance;
    }

    public String singlePutDay(String name){
        Select select = new Select(singleSelect);
        select.selectByVisibleText(name);
        wait.until(ExpectedConditions.presenceOfElementLocated(singleResult));
        return webDriver.findElement(singleResult).getText();
    }

    public String multiPutCityButtonFirst(String [] city){
        Select select = new Select(multiSelect);
        for(String s : city){
            select.selectByVisibleText(s);
        }
        multiButtonFirst.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(multiResult));
        return webDriver.findElement(multiResult).getText();
    }

    public String multiPutCityButtonAll(String [] city){
        Select select = new Select(multiSelect);
        for(String s : city){
            select.selectByVisibleText(s);
        }
        multiButtonAll.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(multiResult));
        return webDriver.findElement(multiResult).getText();
    }

    public void waitForRefresh(){
        Refresh();
        wait.until(ExpectedConditions.stalenessOf(multiButtonFirst));
        Init();
    }

}
