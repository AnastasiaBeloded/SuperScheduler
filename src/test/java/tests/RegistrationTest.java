package tests;

import manager.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.LoginScreen;

public class RegistrationTest extends Configuration {


    @Test
    public void registrationSuccess(){
        int i =(int)(System.currentTimeMillis()/1000)%3600;

        boolean addPresent = new LoginScreen(driver)
                .fillEmail("May"+i+"@mail.com")
                .fillPassword("May1234$")
                .submitRegistration()
                .skipWizard()
                .isFabAddPresent();
        Assert.assertTrue(addPresent);
    }
}
