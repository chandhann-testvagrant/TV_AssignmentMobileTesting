package testSetup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseSetup {
    protected AppiumDriver driver;
   protected AppiumDriverLocalService appiumService;


//before method--------
    //change apk into project
    @BeforeMethod
    public void setup() throws MalformedURLException {
//        {
//            "app": "/Users/chandhann/Downloads/HR management app Zoho People_v6.94_apkpure.com.apk",
//                "platformName": "Android",
//                "deviceName": "Samsung Galaxy S10",
//                "appWaitDuration": "50",
//                "platformVersion": "9.0",
//                "newCommandTimeout": "60",
//                "fullReset": "true",
//                "clearSystemFiles": "true"
  //      "appActivity": "com.zoho.people.znew.HomeActivityNew",
    //            "appWaitActivity": "com.zoho.people.activities.LoaderActivity"
//        }

        appiumService = AppiumDriverLocalService.buildDefaultService();
        appiumService.start();
        appiumService.clearOutPutStreams();
        String appiumServiceUrl= appiumService.getUrl().toString();
        System.out.println("Appium Service Address : - "+ appiumServiceUrl);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", System.getProperty("user.dir")+"/zoho.apk");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Google Pixel");
        capabilities.setCapability("adbExecTimeout", "30000");
        capabilities.setCapability("appActivity", "com.zoho.people.znew.HomeActivityNew");
        //capabilities.setCapability("appWaitActivity", "com.zoho.people.activities.LoaderActivity");
        capabilities.setCapability("noReset", "true");

        driver = new AndroidDriver<>(new URL(appiumServiceUrl), capabilities);



    }
  
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if(driver!=null)
        {driver.quit();}
        appiumService.stop();
    }



}
