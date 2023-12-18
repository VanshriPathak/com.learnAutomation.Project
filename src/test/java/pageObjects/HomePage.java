package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;
public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath = "//span[text()='Manage']")
			WebElement lnkManage; 
	
	@FindBy (xpath = "//img[@alt='menu']")
	WebElement lnkMenu; 

	@FindBy (xpath = "//a[text()=\"Manage Courses\"]")
	WebElement lnkManageCourses; 
	
	@FindBy (xpath = "//button[text()='Sign out']")
	WebElement lnkSignOut; 
	
	public boolean isManageDisplayed(){
	    boolean status=lnkManage.isDisplayed();
	    return status;
	}
	
	public void signOutFromApplication(){
		lnkMenu.click();
		lnkSignOut.click();
	}
	
	public void selectManageCourse() {
		Actions act=new Actions(driver);
		act.moveToElement(lnkManage).build().perform();
		act.moveToElement(lnkManageCourses).click().build().perform();
	}
	
	
}
