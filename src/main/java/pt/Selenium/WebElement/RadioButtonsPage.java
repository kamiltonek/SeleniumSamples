package pt.Selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

//Input Forms --> Radio Buttons Demo
public class RadioButtonsPage extends BasicPage {
    private static RadioButtonsPage instance;

    private WebElement singleRadioButtonMale;
    private WebElement singleRadioButtonFemale;
    private WebElement singleButton;
    By singleResult = By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[2]/p[3]");

    private WebElement multipleRadioButtonMale;
    private WebElement multipleRadioButtonFemale;
    private WebElement multipleRadioButtonAge05;
    private WebElement multipleRadioButtonAge515;
    private WebElement multipleRadioButtonAge1550;
    private WebElement multipleButton;
    By multipleResult = By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/p[2]");

    private RadioButtonsPage() {
        webDriver.get(TEST_PAGE + "basic-radiobutton-demo.html");
        Init();
    }

    private void Init(){
        singleRadioButtonMale = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[2]/label[1]/input"));
        singleRadioButtonFemale = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[2]/label[2]/input"));
        singleButton = webDriver.findElement(By.id("buttoncheck"));


        multipleRadioButtonMale = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div[1]/label[1]/input"));
        multipleRadioButtonFemale = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div[1]/label[2]/input"));
        multipleRadioButtonAge05 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div[2]/label[1]/input"));
        multipleRadioButtonAge515 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div[2]/label[2]/input"));
        multipleRadioButtonAge1550 = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div[2]/label[3]/input"));
        multipleButton = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/button"));
    }

    public static RadioButtonsPage getInstance() {
        if(instance == null){
            instance = new RadioButtonsPage();
        }
        return instance;
    }

    public String singleNullCheck(){
        singleButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(singleResult));
        return  webDriver.findElement(singleResult).getText();
    }

    public String singleMaleCheck(){
        singleRadioButtonMale.click();
        singleButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(singleResult));
        return webDriver.findElement(singleResult).getText();
    }

    public String singleFemaleCheck(){
        singleRadioButtonFemale.click();
        singleButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(singleResult));
        return  webDriver.findElement(singleResult).getText();
    }

    public String multipleResult(int val1, int val2){
        switch (val1){
            case 0:
                multipleRadioButtonMale.click();
                break;
            case 1:
                multipleRadioButtonFemale.click();
                break;
            default:
                break;
        }
        switch (val2){
            case 0:
                multipleRadioButtonAge05.click();
                break;
            case 1:
                multipleRadioButtonAge515.click();
                break;
            case 2:
                multipleRadioButtonAge1550.click();
                break;
            default:
                break;

        }
        multipleButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(multipleResult));
        return webDriver.findElement(multipleResult).getText();
    }

    public void waitForRefresh(){
        Refresh();
        wait.until(ExpectedConditions.stalenessOf(singleButton));
        Init();
    }
}
