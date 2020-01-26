package pt.Selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

//Progress Bars & Sliders --> JQuery Download Progress bars
public class JQueryDownloadProgressBarsPage extends BasicPage {
    private static JQueryDownloadProgressBarsPage instance;

    private WebElement startDownloadButton;
    private WebElement temp;
    By text = By.xpath("/html/body/div[3]/div[2]/div[1]");
    By resultButton = By.xpath("/html/body/div[3]/div[3]/div/button");

    private JQueryDownloadProgressBarsPage(){
        webDriver.get(TEST_PAGE + "jquery-download-progress-bar-demo.html");
        Init();
    }

    private void Init() {
        startDownloadButton = webDriver.findElement(By.id("downloadButton"));
        temp = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/h2"));
    }

    public static JQueryDownloadProgressBarsPage getInstance() {
        if(instance == null){
            instance = new JQueryDownloadProgressBarsPage();
        }
        return instance;
    }

    public String startDownload(){
        startDownloadButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(text));
        wait.until(ExpectedConditions.textToBePresentInElement(webDriver.findElement(text), "Complete!"));

        return wait.until(ExpectedConditions.presenceOfElementLocated(resultButton)).getText();
    }

    public void waitForRefresh(){
        Refresh();
        wait.until(ExpectedConditions.stalenessOf(temp));
        Init();
    }
}
