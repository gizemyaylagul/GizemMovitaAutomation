package Test;

import Base.BaseMovita;
import Utilities.Browsers;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Test1 extends BaseMovita {

    @Test(priority = 0)
    public void openMovita(){

        open();
    }
    @Test(priority = 1,dependsOnMethods = "openMovita")
    public void logo(){
        click(llogo);
        //visible(ttext);
        bekle(3000);
        assertLoc(ttext,str);
        getScreenShot("MobilVasıta");
    }
    @Test(priority = 3)
    public void Enter(){
        click(Ddrop);
        click(English);
        getScreenShot("Login");
    }
    @Test(priority = 2)
    public void Enter2 (){
        click(Ddrop);
        bekle(1000);
        click(Turkce);
        getScreenShot("Giriş");

    }
    @Test(dependsOnMethods = "openMovita")
    public void headerMenu(){
        headerOver();
    }

}
