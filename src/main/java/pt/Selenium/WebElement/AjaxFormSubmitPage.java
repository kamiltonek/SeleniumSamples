package pt.Selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

//Input Forms --> Ajax Form Submit
public class AjaxFormSubmitPage extends BasicPage {
    private static AjaxFormSubmitPage instance;

    private WebElement title;
    private WebElement description;
    private WebElement buttonSumbit;
    private WebElement submitControl;

    private AjaxFormSubmitPage(){
        webDriver.get(TEST_PAGE + "ajax-form-submit-demo.html");

        Init();
    }

    private void Init() {
        title = webDriver.findElement(By.id("title"));
        description = webDriver.findElement(By.id("description"));
        buttonSumbit = webDriver.findElement(By.id("btn-submit"));
        submitControl = webDriver.findElement(By.id("submit-control"));
    }

    public static AjaxFormSubmitPage getInstance() {
        if(instance == null){
            instance = new AjaxFormSubmitPage();
        }
        return instance;
    }

    public String getResult(String txt1, String txt2){
        title.sendKeys(txt1);
        description.sendKeys(txt2);
        buttonSumbit.click();

        wait.until(ExpectedConditions.invisibilityOf(buttonSumbit));
        wait.until(ExpectedConditions.textToBePresentInElement(submitControl, "Form submited Successfully!"));

        return submitControl.getText();
    }

    public void waitForRefresh(){
        Refresh();
        wait.until(ExpectedConditions.stalenessOf(title));
        Init();
    }

}
