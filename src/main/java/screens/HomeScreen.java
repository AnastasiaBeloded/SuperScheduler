package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class HomeScreen extends BaseScreen{
    public HomeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_main']")
    MobileElement fabAdd;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_add_event']")
    MobileElement fabAddEvent;
    @FindBy(xpath = "//*[@content-desc='Open']")
    MobileElement burgerMenu;
    @FindBy(xpath = "//*[@content-desc='Open']")
    MobileElement logoutButton;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/row_container_main']")
    List<MobileElement> listEvents;

    public EditCreateEventScreen selectFirstEvent(){
        pause(2000);
        listEvents.get(0).click();

        return new EditCreateEventScreen(driver);

    }

    public EditCreateEventScreen initCreationEvent(){
        checkFabButtonPresentAssert();
        fabAdd.click();
        fabAddEvent.click();
        return new EditCreateEventScreen(driver);
    }
    public HomeScreen checkFabButtonPresentAssert(){
        should(fabAdd,10);
        Assert.assertTrue(fabAdd.isDisplayed());
        return this;
    }

    public boolean isFabAddPresent(){
        should(fabAdd,10);

       return fabAdd.isDisplayed();
    }

    public HomeScreen openMenu(){
        if(isDisplayedWithExp(burgerMenu)){
            burgerMenu.click();
        }
        return this;
    }

    public LoginScreen logOut(){
        if(isDisplayedWithExp(logoutButton)) {
            logoutButton.click();
        }
        return new LoginScreen(driver);
    }


}
