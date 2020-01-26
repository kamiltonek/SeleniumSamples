package pt.Selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

//Input Forms --> Checkbox Demo
public class CheckboxDemo extends BasicPage {
    private static CheckboxDemo instance;

    private WebElement singleCheckbox;
    By singleCheckboxResult = By.id("txtAge");

    private WebElement multipleCheckbox1;
    private WebElement multipleCheckbox2;
    private WebElement multipleCheckbox3;
    private WebElement multipleCheckbox4;
    private WebElement multipleCheckboxButton;

    private CheckboxDemo() {
        webDriver.get(TEST_PAGE + "basic-checkbox-demo.html");
        Init();
    }

    private void Init(){
        singleCheckbox = webDriver.findElement(By.id("isAgeSelected"));

        multipleCheckbox1 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div[1]/label/input"));
        multipleCheckbox2 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div[2]/label/input"));
        multipleCheckbox3 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div[3]/label/input"));
        multipleCheckbox4 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div[4]/label/input"));
        multipleCheckboxButton = webDriver.findElement(By.id("check1"));
    }

    public static CheckboxDemo getInstance() {
        if(instance == null){
            instance = new CheckboxDemo();
        }
        return instance;
    }

    public String checkAndGetResult(){
        singleCheckbox.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(singleCheckboxResult));
        return webDriver.findElement(singleCheckboxResult).getText();
    }

    public String checkAndGetResult(boolean b1, boolean b2, boolean b3, boolean b4){
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", multipleCheckbox1);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(b1){
            multipleCheckbox1.click();
        }
        if(b2){
            multipleCheckbox2.click();
        }
        if(b3){
            multipleCheckbox3.click();
        }
        if(b4){
            multipleCheckbox4.click();
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("check1")) );
        return multipleCheckboxButton.getAttribute("value");
    }

    public void waitForRefresh(){
        Refresh();
        wait.until(ExpectedConditions.stalenessOf(singleCheckbox));
        Init();
    }

}
