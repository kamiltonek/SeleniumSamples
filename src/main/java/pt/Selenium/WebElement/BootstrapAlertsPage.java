package pt.Selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

//Alerts & Modals --> Bootstrap Alert
public class BootstrapAlertsPage extends BasicPage {
    private static BootstrapAlertsPage instance;

    private WebElement successAutocloseable;
    private WebElement successNormal;
    private WebElement warningAutocloseable;
    private WebElement warningNormal;
    private WebElement dangerAutocloseable;
    private WebElement dangerNormal;
    private WebElement infoAutocloseable;
    private WebElement infoNormal;


    private BootstrapAlertsPage(){
        webDriver.get(TEST_PAGE + "bootstrap-alert-messages-demo.html");

        Init();
    }

    private void Init() {
        successAutocloseable = webDriver.findElement(By.id("autoclosable-btn-success"));
        successNormal = webDriver.findElement(By.id("normal-btn-success"));
        warningAutocloseable = webDriver.findElement(By.id("autoclosable-btn-warning"));
        warningNormal = webDriver.findElement(By.id("normal-btn-warning"));
        dangerAutocloseable = webDriver.findElement(By.id("autoclosable-btn-danger"));
        dangerNormal = webDriver.findElement(By.id("normal-btn-danger"));
        infoAutocloseable = webDriver.findElement(By.id("autoclosable-btn-info"));
        infoNormal = webDriver.findElement(By.id("normal-btn-info"));
    }

    public static BootstrapAlertsPage getInstance() {
        if(instance == null){
            instance = new BootstrapAlertsPage();
        }
        return instance;
    }

    public boolean clickAutocloseableAlert(String name){
        WebElement newAlert = null;

        switch (name){
            case "success":
                successAutocloseable.click();
                newAlert = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[1]")));
                break;
            case "warning":
                warningAutocloseable.click();
                newAlert = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]")));
                break;
            case "danger":
                dangerAutocloseable.click();
                newAlert = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[5]")));
                break;
            case "info":
                infoAutocloseable.click();
                newAlert = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[7]")));
                break;
            default:
                break;
        }
        if(newAlert != null){
            wait.until(ExpectedConditions.invisibilityOf(newAlert));
        }
        return !Objects.requireNonNull(newAlert).isDisplayed();
    }

    public boolean clickNormalAlert(String name){
        WebElement newAlert = null;

        switch (name){
            case "success":
                successNormal.click();
                newAlert = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]")));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/button"))).click();
                break;
            case "warning":
                warningNormal.click();
                newAlert = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[4]")));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[4]/button"))).click();
                break;
            case "danger":
                dangerNormal.click();
                newAlert = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[6]")));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[6]/button"))).click();
                break;
            case "info":
                infoNormal.click();
                newAlert = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[8]")));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[8]/button"))).click();
                break;
            default:
                break;
        }

        if(newAlert != null){
            wait.until(ExpectedConditions.invisibilityOf(newAlert));
        }
        return !Objects.requireNonNull(newAlert).isDisplayed();
    }

    public void waitForRefresh(){
        Refresh();
        wait.until(ExpectedConditions.stalenessOf(successAutocloseable));
        Init();
    }
}
