package pt.Selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

//Input Forms --> Simple Form Demo
public class SimpleFormDemoPage extends BasicPage {
    private static SimpleFormDemoPage instance;

    private WebElement singleInputField;
    private WebElement singleInputButton;
    By singleInputResult = By.id("display");

    private WebElement doubleInputSum1;
    private WebElement doubleInputSum2;
    private WebElement doubleInputButton;
    By doubleInputResult = By.id("displayvalue");



    private SimpleFormDemoPage() {
        webDriver.get(TEST_PAGE + "basic-first-form-demo.html");
        Init();
    }

    private void Init(){
        singleInputField = webDriver.findElement(By.id("user-message"));
        singleInputButton = webDriver.findElement(By.xpath("//form[@id='get-input']/button"));

        doubleInputSum1 = webDriver.findElement(By.id("sum1"));
        doubleInputSum2 = webDriver.findElement(By.id("sum2"));
        doubleInputButton = webDriver.findElement(By.xpath("//form[@id='gettotal']/button"));
    }

    public static SimpleFormDemoPage getInstance() {
        if(instance == null){
            instance = new SimpleFormDemoPage();
        }
        return instance;
    }

    public String getResult(String message){
        singleInputField.sendKeys(message);
        singleInputButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(singleInputResult));
        return webDriver.findElement(singleInputResult).getText();

    }

    public String getResult(String a, String b){
        doubleInputSum1.sendKeys(a);
        doubleInputSum2.sendKeys(b);
        doubleInputButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(doubleInputResult));
        return webDriver.findElement(doubleInputResult).getText();
    }

    public void waitForRefresh(){
        Refresh();
        wait.until(ExpectedConditions.stalenessOf(singleInputButton));
        Init();
    }

}