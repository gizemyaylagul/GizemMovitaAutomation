package Base;

import Locaators.Locator;
import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

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
    public void beforeSuite(){
        driver=Driver.getDriver();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterSuite
    public void afterSuite(){
        Driver.quitDriver();
    }
    public void open(){
        driver.get(url);
    }

}
