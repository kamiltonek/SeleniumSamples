package pt.Selenium.WebElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasicPage {
    protected final String TEST_PAGE = "https://www.seleniumeasy.com/test/";
    protected WebDriver webDriver;
    protected WebDriverWait wait;

    public BasicPage() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Programy\\chromedriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 10);
        webDriver.manage().window().maximize();
    }

    public void closeDriver(){
        webDriver.close();
    }

    protected void Refresh(){
        webDriver.navigate().refresh();
        webDriver.manage().deleteAllCookies();
    }
}
