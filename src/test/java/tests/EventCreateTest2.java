package tests;


import manager.Configuration;
import models.Event;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;


public class EventCreateTest2 extends Configuration {


    @Test
    public void createNewEvent(){
        Event event = Event.builder()
                .title("Birthday")
                .type("For Mary")
                .breaks(1)
                .wage(100)
                .build();

        boolean isFabPresent = new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(event)
                .isFabAddPresent();
        Assert.assertTrue(isFabPresent);



    }
    @Test
    public void createNewEvent2(){
        Event event = Event.builder()
                .title("Birthday")
                .type("For Dobby")
                .breaks(2)
                .wage(10)
                .build();

        boolean isFabPresent = new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(event)
                .isFabAddPresent();
        Assert.assertTrue(isFabPresent);



    }
    @Test
    public void createNewEvent3(){
        new LoginScreen(driver)
                .complexLogin(User.builder().email("candy@gmail.com").password("Ckandy123$").build())
                .initCreationEvent()
                .dataAction()
                .createNewEvent(Event.builder().title("Me Title").type("My Type").breaks(2).wage(50).build())
                .checkFabButtonPresentAssert()
                .openMenu()
                .logOut();
    }
    @Test
    public void createNewEventCheckData(){

        new LoginScreen(driver)
                .complexLogin(User.builder().email("candy@gmail.com").password("Ckandy123$").build())
                .initCreationEvent()
                .selectDataAction("18/08/2022")
                .createNewEvent(Event.builder().title("Me Title1").type("My Type").breaks(2).wage(50).build())
                .checkFabButtonPresentAssert()
                .openMenu()
                .logOut();


    }



}
