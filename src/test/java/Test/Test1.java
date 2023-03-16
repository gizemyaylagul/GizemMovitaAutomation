package Test;

import Base.BaseMovita;
import org.testng.annotations.Test;

public class Test1 extends BaseMovita {



    @Test(priority = 0)
    public void openMovita(){

        open();
    }
    @Test(priority = 1)
    public void logo(){
        click(llogo);
    }



}
