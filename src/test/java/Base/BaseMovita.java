package Base;

import Locaators.Locator;
import Utilities.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseMovita implements Locator {
    private WebDriver driver;
    private WebDriverWait wait;

    /*
        public BaseTest() {
            driver=Driver.getDriver();
            wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        }
        {
            driver=Driver.getDriver();
            wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        }*/
    @BeforeSuite
    public void beforeSuite() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void afterSuite() {
        Driver.quitDriver();
    }

    public void open() {
        driver.get(url);
    }

    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        click(element);

    }

    public void click(WebElement element) {
        element.click();

    }

    public void visible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }

    public void assertLoc(By locator, String str) {
        WebElement element = driver.findElement(locator);
        String text = element.getText();
        System.out.println(text);

        Assert.assertEquals(text, str);
    }

    public void bekle(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void getScreenShot(String name) {
        String filedesk= "screenshot/"+name+ " "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+".png";
        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File target = new File(filedesk);
        try {
            FileUtils.copyFile(source,target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}


