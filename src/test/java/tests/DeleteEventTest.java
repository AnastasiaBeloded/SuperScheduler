package tests;

import manager.Configuration;
import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.LoginScreen;

public class DeleteEventTest extends Configuration {

    @BeforeClass
    public void preCondition(){
        new LoginScreen(driver)
                .complexLogin(User.builder().email("candy@gmail.com").password("Ckandy123$").build());

    }

    @Test
    public void deleteEventSuccess(){
        new LoginScreen(driver)
                .complexLogin(User.builder().email("noa@gmail.com").password("Nnoa12345$").build())
                .selectFirstEvent()
                .deleteEvent()
                .checkFabButtonPresentAssert()
                .openMenu()
                .logOut();

    }
}
