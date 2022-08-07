package tests;///mia@gmail.com  Mmia12345$

import manager.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class LoginTest extends Configuration {



    @Test
      public void loginTestSuccess(){
        boolean addPresent = new SplashScreen(driver)
                .checkCurrentVersion("0.0.3")
                .fillEmail("candy@gmail.com")
                .fillPassword("Ckandy123$")
                .submitLogin()
                .isFabAddPresent();

        Assert.assertTrue(addPresent);


    }


}
