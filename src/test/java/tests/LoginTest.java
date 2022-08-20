package tests;///mia@gmail.com  Mmia12345$

import manager.Configuration;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;
import screens.SplashScreen;

public class LoginTest extends Configuration {



    @Test
      public void loginTestSuccess(){
       // boolean addPresent = new SplashScreen(driver)
               // .checkCurrentVersion("0.0.3")
        boolean addPresent =new LoginScreen(driver)
                .fillEmail("candy@gmail.com")
                .fillPassword("Ckandy123$")
                .submitLogin()
                .isFabAddPresent();

        Assert.assertTrue(addPresent);


    }
    @Test
    public void loginTestSuccess2(){
       // boolean addPresent = new SplashScreen(driver)
             //   .checkCurrentVersion("0.0.3")
        boolean addPresent = new LoginScreen(driver)
                .fillEmail("candy@gmail.com")
                .fillPassword("Ckandy123$")
                .submitLogin()
                .isFabAddPresent();

        Assert.assertTrue(addPresent);


    }
    @Test
    public  void  loginSuccessModel(){
        User user = User.builder().email("candy@gmail.com").password("Ckandy123$").build();
        boolean addPresent= new LoginScreen(driver)
                .complexLogin(user)
                .isFabAddPresent();
        Assert.assertTrue(addPresent);
    }
    @Test
    public  void  loginNegativeModelWrongPassword(){
        User user = User.builder().email("candy@gmail.com").password("Ckandy1$").build();
        new LoginScreen(driver)
                .complexLoginNagative(user)
                .checkErrorMessage("Wrong email or password")
                .confirmError();

    }
    @Test
    public void loginSuccessModel1() {


        User user = User.builder().email("noa@gmail.com").password("Nnoa12345$").build();
        logger.info("Test start with user -->" + user.toString());
        boolean addPresent = new LoginScreen(driver)
                .complexLogin(user)
                .isFabAddPresent();
    }



    @AfterMethod
    public void postCondition(){
        new HomeScreen(driver)
                .openMenu()
                .logOut();



    }


}
