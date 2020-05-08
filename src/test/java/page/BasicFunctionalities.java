package page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class BasicFunctionalities extends BaseActions {
    BasicFunctionalities(AppiumDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(id = "com.streetline.parker:id/maps_toolbar_autocomplete")private WebElement searchBar;
    @FindBys({@FindBy(xpath = "//*[@resource-id='com.streetline.parker:id/maps_search_listview']/android.widget.RelativeLayout[1]")})private List<WebElement> searchResult;
    public void searchAndSelectFirstResult(String locationName) {
        click(searchBar);
        type(searchBar,locationName+"\n");
        //sleep(3000);
        //sleep(3000);
        reinitializePage(this);
        click(searchResult.get(0));
    }
    
    
    
    
}
