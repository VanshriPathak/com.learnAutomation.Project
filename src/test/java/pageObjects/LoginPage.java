package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
@FindBy (xpath="//input[@id='email1']")
WebElement txtUser; 

@FindBy (xpath="//input[@id='password1']")
WebElement txtPassword; 

@FindBy (xpath="//button[text()='Sign in']")
WebElement btnSignIn; 

@FindBy (xpath="//h2[normalize-space()='Sign In']")
WebElement loginSignInOption;

@FindBy (xpath="//div[@class='social-btns']//a")
WebElement socialMediaCount;

@FindBy (xpath="//a[text()='New user? Signup']")
WebElement lnkNewUser;

public void setUsername (String uname) {
	txtUser.sendKeys(uname);
}

public void setPassword(String pwd) {
	txtPassword.sendKeys(pwd);
}
public void clickSignIn() {
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnSignIn);
	//btnSignIn.click();
} 

public void numberOfSocialMediaIcons() {
	
	
}

public boolean isSignInDisplayed() 
{
	
	return loginSignInOption.isDisplayed();
}

public void clickNewUser() {
	((JavascriptExecutor) driver).executeScript("arguments[0].click();",lnkNewUser );
}
	
}
