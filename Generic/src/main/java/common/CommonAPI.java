package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CommonAPI {

        public static WebDriver driver=null;

        public WebDriver setBrowser(String OS,String Browser){
            if (OS.equalsIgnoreCase("windows")&& Browser.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver","Generic/BrowserDriver/Windows/chromedriver.exe");
                driver=new ChromeDriver();
            }else if (OS.equalsIgnoreCase("mac")&& Browser.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver","BrowserDriver/Windows/chromedriver.exe");
                driver=new ChromeDriver();
            }
            return driver;
        }

    public void clickByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public void typeByCss(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }

    public static void scrollUpDown(int scrollValue){
        JavascriptExecutor scroll=(JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,"+scrollValue+")");

    }
    public static void scrollToFooter(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }


    //((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");

    public static void assertCheck(String actual,String expected){
        Assert.assertEquals(actual,expected);
        System.out.println("Test Passed");
    }

    public static void scrollToWebElement(String path){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(By.xpath(path)));
    }


}
