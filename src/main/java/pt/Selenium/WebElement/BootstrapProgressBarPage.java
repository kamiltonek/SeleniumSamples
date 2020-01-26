package pt.Selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Progress Bars & Sliders --> Bootstrap Progress bar
public class BootstrapProgressBarPage extends BasicPage {
    private static BootstrapProgressBarPage instance;

    private WebElement button;
    private WebElement progress;

    private BootstrapProgressBarPage(){
        webDriver.get(TEST_PAGE + "bootstrap-download-progress-demo.html");

        Init();
    }

    private void Init() {
        button = webDriver.findElement(By.id("cricle-btn"));
        progress = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/div/div/div/div/div[1]"));
    }

    public static BootstrapProgressBarPage getInstance() {
        if(instance == null){
            instance = new BootstrapProgressBarPage();
        }
        return instance;
    }

    public boolean clickAndDownload(){
        WebDriverWait wait = new WebDriverWait(webDriver, 100);
        button.click();
        wait.until(ExpectedConditions.textToBePresentInElement(progress, "100%"));
        return progress.getText().equals("100%");
    }

    public void waitForRefresh(){
        Refresh();
        wait.until(ExpectedConditions.stalenessOf(button));
        Init();
    }

}
