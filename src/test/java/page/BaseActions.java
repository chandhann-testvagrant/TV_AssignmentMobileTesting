package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import model.location;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

public class BaseActions {
    
    private AppiumDriver driver;
    protected WebDriverWait wait;
    protected <T extends BaseActions> void reinitializePage(T obj){
        
        PageFactory.initElements(getDriverInstance(),obj);
        
        
    }
   protected BaseActions(AppiumDriver driver){
        this.driver=driver;
        wait= new WebDriverWait(driver, Constants.explicitWaitInSeconds);
    }
    protected AppiumDriver getDriverInstance(){
        return driver;
    }
    
    protected void click(WebElement element){
        for(int i=0; i<=2;i++){
            try{
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                break;
            }catch(StaleElementReferenceException e){}
        }
      //  wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
       
    }
    
    public void setDeviceLocation(location location){
        
        driver.setLocation(new Location(location.getLatitude(),location.getLogitude(),location.getAltitude()));
       
    }
    
    protected String getText(WebElement element){
       String text="";
        for(int i=0; i<=2;i++){
            try{
                TouchActions action = new TouchActions(driver);
                action.scroll(element, 10, 100);
                action.perform();
    
    
                text= wait.until(ExpectedConditions.visibilityOf(element)).getText();
               
                break;
            }catch(StaleElementReferenceException e){}
        }
        //  wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
        return text;
    }
    
    protected void scrollToText(String text){
        MobileElement element = (MobileElement) getDriverInstance().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.zoho.people:id/viewpager\")).getChildByText("
                + "new UiSelector().className(\"android.widget.TextView\"), \""+text+"\")"));
    }
   
    protected boolean isDisplayed(WebElement element,int longInSec){
       boolean flag=false;
       
       if(!waitTillElementVisible(element,longInSec)){
           return false;
       }
       
        for(int i=0; i<=2;i++){
            try{
                flag=element.isDisplayed();
                break;
            }catch(StaleElementReferenceException e){}
        }
        return flag;
    }
    
    protected boolean waitTillElementVisible(WebElement element,int timeOutInSec){
       boolean flag=false;
       try{
       new WebDriverWait(driver,timeOutInSec).until(ExpectedConditions.visibilityOf(element));flag=true;}catch (TimeoutException e){}
       return flag;
    }
    
    protected void sleep(long inMilliSec){
        try{
            Thread.sleep(inMilliSec);
        }catch (InterruptedException e){
        
        }
    }
    
    protected void type(WebElement element,String value){
        for(int i=0; i<=2;i++){
            try{
                wait.until(ExpectedConditions.visibilityOf(element)).clear();
                        element.sendKeys(value);
                break;
            }catch(StaleElementReferenceException e){}
        }
      //  wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
      
    }
    
   
    
    
    
}
