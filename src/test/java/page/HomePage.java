package page;

import io.appium.java_client.AppiumDriver;
import model.address;
import model.location;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasicFunctionalities {
    public HomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    
    @FindBy(xpath = "//*[@text ='New update is available!']")private WebElement newUpdateAvailablePopUp;
    @FindBy(xpath = "//*[@text ='IGNORE']")private WebElement newUpdateAvailablePopUpIgnoreButton;
    public HomePage ignoreUpdatePopUp() {
        
            if (isDisplayed(newUpdateAvailablePopUp,10)) {
                click(newUpdateAvailablePopUpIgnoreButton);
            }
        return this;
    }
    
    @FindBy(id="com.streetline.parker:id/maps_fab_park_button")private WebElement parkFloatIcon;
    @FindBy(id="com.streetline.parker:id/maps_park_banner_label")private WebElement setParkingLocationButton;
    public HomePage parkTheCar(){
        click(parkFloatIcon);
        reinitializePage(this);
        click(setParkingLocationButton);
        return this;
    }
    
    @FindBy(id="com.streetline.parker:id/dismiss_park_location_button")private WebElement dismissParkingLocationButton;
    public HomePage dismissTheParking(){
        click(dismissParkingLocationButton);
        return this;
    }
    
    @FindBy(id="com.streetline.parker:id/youParkedAtTxt")private WebElement timeOfParkingLocationText;
    @FindBy(id="com.streetline.parker:id/maps_address_text")private WebElement addressLine1OfParkingLocationText;
    @FindBy(id="com.streetline.parker:id/maps_address_text2")private WebElement addressLine2OfParkingLocationText;
    
    public address getAddressOfParkLocation(){
    
        address address=new address();
        address.setAddressLine1(getText(addressLine1OfParkingLocationText));
        address.setAddressLine2(getText(addressLine2OfParkingLocationText));
        address.setTime(getText(timeOfParkingLocationText));
        
        return address;
    }
    
    @FindBy(id="com.streetline.parker:id/maps_fab_center_button")private WebElement centerFloatIcon;
    public HomePage recenterLocation(location location){
        click(centerFloatIcon);
        
        setDeviceLocation(location);
        click(centerFloatIcon);
        return this;
    }
    
    
    @FindBy(id="com.streetline.parker:id/maps_toolbar_filter")private WebElement filterButton;
    @FindBy(xpath="//*[@resource-id='com.streetline.parker:id/maps_toolbar_toolbar']/*[1]")private WebElement menuButton;
    @FindBy(id="com.streetline.parker:id/activity_maps_drawer_notifications")private WebElement notificationSettingButton;
    
    @FindBys({@FindBy(id="android:id/switch_widget")})private List<WebElement> notificationSettingsList;
    public HomePage changeNotificationSetting(boolean navigation,boolean timer,boolean park){
        click(menuButton);
        click(notificationSettingButton);
        reinitializePage(this);
        if(navigation){
            if(!getText(notificationSettingsList.get(0)).equals("ON")){
                click(notificationSettingsList.get(0));
            }
        }else{
            if(getText(notificationSettingsList.get(0)).equals("ON")){
                click(notificationSettingsList.get(0));
            }
        }
    
        if(timer){
            if(!getText(notificationSettingsList.get(1)).equals("ON")){
                click(notificationSettingsList.get(1));
            }
        }else{
            if(getText(notificationSettingsList.get(1)).equals("ON")){
                click(notificationSettingsList.get(1));
            }
        }
    
        if(park){
            if(!getText(notificationSettingsList.get(2)).equals("ON")){
                click(notificationSettingsList.get(2));
            }
        }else{
            if(getText(notificationSettingsList.get(2)).equals("ON")){
                click(notificationSettingsList.get(2));
            }
        }
        
        getDriverInstance().navigate().back();
        
        return this;
    }
    
    
    
}