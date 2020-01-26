package pt.Selenium.WebElement;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

//Alerts & Modals --> Javascript Alerts
public class JavascriptAlertsPage extends BasicPage {
    private static JavascriptAlertsPage instance;

    private WebElement button1;
    private WebElement button2;
    private WebElement button3;

    private JavascriptAlertsPage(){
        webDriver.get(TEST_PAGE + "javascript-alert-box-demo.html");
        Init();
    }

    private void Init(){
        button1 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[2]/button"));
        button2 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/button"));
        button3 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div[2]/button"));
    }

    public static JavascriptAlertsPage getInstance() {
        if(instance == null){
            instance = new JavascriptAlertsPage();
        }
        return instance;
    }

    public boolean firstAlertIsPresent()
    {
        button1.click();
        try
        {
            webDriver.switchTo().alert().accept();
            return true;
        }
        catch (NoAlertPresentException Ex)
        {
            return false;
        }
    }

    public String firstAlertShow(){
        button1.click();

        Alert alert = webDriver.switchTo().alert();

        String text = alert.getText();
        alert.accept();

        return text;
    }

    public boolean firstAlertClickOK(){
        button1.click();

        Alert alert = webDriver.switchTo().alert();

        alert.accept();

        try
        {
            webDriver.switchTo().alert();
            return false;
        }
        catch (NoAlertPresentException Ex)
        {
            return true;
        }
    }

    public boolean secondAlertIsPresent()
    {
        button2.click();
        try
        {
            webDriver.switchTo().alert().accept();
            return true;
        }
        catch (NoAlertPresentException Ex)
        {
            return false;
        }
    }

    public String secondAlertShow(){
        button2.click();

        Alert alert = webDriver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        return text;
    }

    public boolean secondAlertClickOK(){
        button2.click();

        Alert alert = webDriver.switchTo().alert();

        alert.accept();

        try
        {
            webDriver.switchTo().alert();
            return false;
        }
        catch (NoAlertPresentException Ex)
        {
            return true;
        }
    }

    public boolean thirdAlertIsPresent()
    {
        button3.click();
        try
        {
            webDriver.switchTo().alert().accept();
            return true;
        }
        catch (NoAlertPresentException Ex)
        {
            return false;
        }
    }

    public String thirdAlertShow(){
        button3.click();

        Alert alert = webDriver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        return text;
    }

    public boolean thirdAlertClickOK(){
        button3.click();

        Alert alert = webDriver.switchTo().alert();

        alert.accept();

        try
        {
            webDriver.switchTo().alert();
            return false;
        }
        catch (NoAlertPresentException Ex)
        {
            return true;
        }
    }

    public void waitForRefresh(){
        Refresh();
        wait.until(ExpectedConditions.stalenessOf(button1));
        Init();
    }

}
