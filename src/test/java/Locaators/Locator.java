package Locaators;

import org.openqa.selenium.By;

public interface Locator {
    String url="https://movita.com.tr/";
    By llogo= By.id("logo");
    By ttext = By.xpath("//div[@class='tp-mask-wrap']//div[text()='Mobil Vasıta İzleme Takip Sistemi']");
    String str = "Mobil Vasıta İzleme Takip Sistemi";
    By Ddrop= By.xpath("//button[@id='dropdownMenuButton']");
    By English= By.xpath("(//button[@id='dropdownMenuButton']/parent::div//a)[1]");
    By Turkce= By.xpath("(//button[@id='dropdownMenuButton']/parent::div//a)[2]");
    By Anasayfa=By.xpath("//ul[@class='menu-container']//div");


}
