package tests;

import manager.Configuration;
import models.Event;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;

public class EventCreateTest extends Configuration {

    @BeforeClass
    public void preCondition(){
        new LoginScreen(driver)
                .complexLogin(User.builder().email("candy@gmail.com").password("Ckandy123$").build());

    }
    @Test
    public void createNewEventSuccess(){
        Event event = Event.builder()
                .title("Birthday")
                .type("For Joe")
                .breaks(3)
                .wage(50)
                .build();

        boolean isFabPresent = new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(event)
                .isFabAddPresent();
        Assert.assertTrue(isFabPresent);

    }

    @AfterClass
    public void postCondition(){
        new HomeScreen(driver)
                .openMenu()
                .logOut();

    }
}
