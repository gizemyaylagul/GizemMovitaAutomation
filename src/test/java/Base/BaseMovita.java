package Base;

import Locaators.Locator;
import Utilities.Browsers;
import Utilities.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
    @BeforeTest
    @Parameters("browser")
    public void beforeTest(@Optional("CHROME") String browser) {
        driver = Driver.getDriver(Browsers.valueOf(browser));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterTest() {
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
        String filedesk= "screenshot/"+name+ " "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy"))+".png";
        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File target = new File(filedesk);
        try {
            FileUtils.copyFile(source,target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void hoverOver(WebElement element){
        new Actions(driver).moveToElement(element).build().perform();

    }
    public void headerOver(){
        List<WebElement> list=driver.findElements(Anasayfa);
        for (WebElement element:list) {new Actions(driver)
                .pause(500)
                .moveToElement(element)
                .build()
                .perform();


        }
    }


}


