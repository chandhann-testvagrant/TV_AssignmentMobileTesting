package testSuite;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import model.address;
import model.location;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.html5.Location;
import org.testng.annotations.Test;
import page.HomePage;
import testSetup.BaseSetup;
import utils.resourceReader;

import java.io.IOException;
import java.time.Duration;

public class CapstoneTest extends BaseSetup
{

    @Test(priority = 1)
    public void LoginVerificationWithValidCredentials() throws InterruptedException, IOException
    {
        HomePage hp =new HomePage(driver);
        address currentLocation=hp.parkTheCar()
                            .getAddressOfParkLocation();
        hp.dismissTheParking();
        
        System.out.println(currentLocation.getAddressLine1()+currentLocation.getAddressLine2()+currentLocation.getTime());
        location indoorlocation= new location(resourceReader.fileToStringConverter("indoorStadiumLocation.json"));
        hp.recenterLocation(indoorlocation);
        currentLocation=hp.parkTheCar()
                .getAddressOfParkLocation();
        hp.dismissTheParking();
        System.out.println(currentLocation.getAddressLine1()+currentLocation.getAddressLine2()+currentLocation.getTime());
    
    
    
    }
    
    @Test(priority = 2)
    public void TestInCalifornia(){
    
        HomePage hp =new HomePage(driver);
        
    
        location californiaLocation= new location(resourceReader.fileToStringConverter("californiaLocation.json"));
        hp.recenterLocation(californiaLocation);
        address currentLocation=hp.parkTheCar()
                .getAddressOfParkLocation();
        hp.dismissTheParking();
        System.out.println(currentLocation.getAddressLine1()+currentLocation.getAddressLine2()+currentLocation.getTime());
        
        
    }
    
    @Test(priority = 3)
    public void TestApplicationRunInBackground(){
    
     HomePage hp =new HomePage(driver);
     
     hp.changeNotificationSetting(false,false,false);
    
     driver.rotate(ScreenOrientation.LANDSCAPE);
    
     address currentLocation=hp.parkTheCar()
             .getAddressOfParkLocation();
    
     driver.runAppInBackground(Duration.ofSeconds(5));
     hp.dismissTheParking();
    
    
    }
    
    @Test(priority = 4)
    public void killAppAndVerify(){
        
        HomePage hp =new HomePage(driver);
    
        address currentLocation=hp.parkTheCar()
                .getAddressOfParkLocation();
    
        driver.closeApp();
        try {driver.runAppInBackground(Duration.ofSeconds(1));} catch (Exception e){}
    
        driver.launchApp();
    
        hp.dismissTheParking();
        
    }
    
}
