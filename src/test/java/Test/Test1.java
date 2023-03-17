package Test;

import Base.BaseMovita;
import org.testng.Assert;
import org.testng.annotations.Test;

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

}
