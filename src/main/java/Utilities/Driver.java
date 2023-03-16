package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver(){
         return getDriver(Browsers.CHROME);
    }

    public static WebDriver getDriver(Browsers browsers) {
        if (driver == null) {
            switch (browsers) {
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case SAFARI:
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case FİREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    options.addArguments("--headles");
                    driver = new ChromeDriver(options);
                    break;

            }

        }
        return driver;

    }
    public static void quitDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;

        }
    }
}
