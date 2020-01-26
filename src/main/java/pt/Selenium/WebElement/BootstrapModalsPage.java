package pt.Selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


// Alerts & Modals --> Bootstrap Modals
public class BootstrapModalsPage extends BasicPage {
    private static BootstrapModalsPage instance;

    private WebElement singleModelButton;
    By singleClose = By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div/div/div[4]/a[1]");
    By singleSave = By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div/div/div[4]/a[2]");

    private BootstrapModalsPage(){
        webDriver.get(TEST_PAGE + "bootstrap-modal-demo.html");
        Init();
    }

    private void Init(){
        singleModelButton = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[2]/a"));
    }

    public static BootstrapModalsPage getInstance() {
        if(instance == null){
            instance = new BootstrapModalsPage();
        }
        return instance;
    }

    public boolean openSingleModal(boolean close){
        singleModelButton.click();

        if(close){
            wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(singleClose))).click();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(singleSave))).click();
            wait.until(ExpectedConditions.stalenessOf(singleModelButton));
        }
        Init();
        return true;
    }

    public void waitForRefresh(){
        Refresh();
        wait.until(ExpectedConditions.stalenessOf(singleModelButton));
        Init();
    }

}
