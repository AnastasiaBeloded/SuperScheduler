package manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;


public class Configuration {

    protected static  AppiumDriver<MobileElement>driver;
///"platformName": "Android",
//  "deviceName": "Nex",
//  "platformVersion": "8.0",
//  "appPackage": "com.example.svetlana.scheduler",
//  "appActivity": ".presentation.splashScreen.SplashScreenActivity"
       protected Logger logger = LoggerFactory.getLogger(Configuration.class);

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Nex");
        capabilities.setCapability("platformName","Android");
        logger.info("Test starts on Android 8.0");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("appPackage","com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity",".presentation.splashScreen.SplashScreenActivity");
        capabilities.setCapability("automationName","Appium");


        driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver= EventFiringWebDriverFactory.getEventFiringWebDriver(driver,new MyListener());

    }
    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

}
