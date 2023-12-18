package pageObjects;

import java.util.List;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class NewUserRegistrationPage extends BasePage{

	public NewUserRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy (xpath="//*[@id=\"name\"]")
	WebElement txtuname;
	
	@FindBy (xpath="//*[@id=\"email\"]")
	WebElement txtemail;
	
	@FindBy (xpath="//*[@id=\"password\"]")
	WebElement txtpassword;
	
	@FindBys(@FindBy(xpath= "//*[@class=\"interest\"]"))
    List<WebElement> chkboxIntrest;
	
	@FindBys(@FindBy(xpath= "//*[@class=\"gender-div\"]"))
    List<WebElement> chkboxGender;
	
	@FindBy (xpath="//select[@id=\"state\"]")
	WebElement drpState;
	
	@FindBy (xpath="//*[@id='hobbies']")
	WebElement drpHobbies;
	
	@FindBy (xpath="//button[text()=\"Sign up\"]")
	WebElement btnSignUp; 
	
	
	
	@FindBy (xpath="//a[text()='New user? Signup']")
	WebElement btnSignIn; 
	
	@FindBy (xpath="//h2[text()=\"Sign In\"]")
	WebElement msgSignIN; 
	
	public void clickSignIn() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnSignIn);
		
		//btnSignIn.click();
	} 
	public void clickSignUp() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnSignUp);
		
		//btnSignIn.click();
	}
	public void setUserName(String uname) {
		txtuname.sendKeys(uname);
	}
	
	public void setUserEmail(String uemail) {
		txtemail.sendKeys(uemail);
	}
	public void setUserPassword(String upwd ){
		txtpassword.sendKeys(upwd);
	}
	public void selectIntrest(String intrest) {
		for(int i=1;i <= chkboxIntrest.size();i++) {
			String text= chkboxIntrest.get(i).getText();
			if(text.equals(intrest)) {
				chkboxIntrest.get(i).click();
				break;
			}
		}
		}
	public void selectGender(String gender) {
		for(int i=1;i <= chkboxGender.size();i++) {
			String text= chkboxGender.get(i).getText();
			if(text.equals(gender)) {
				chkboxGender.get(i).click();
				break;
			}
		}
	}
	
	public void selectDrpState(String state) {
		
		Select dropdown=new Select( drpState);
		
		dropdown.selectByVisibleText(state);
		
	}
	
public void selectDrpHobbies(String hobby) {
		
		Select dropdown=new Select( drpHobbies);
		
		dropdown.selectByVisibleText(hobby);
		
	}

public boolean signUpMsg() {
	boolean status=false;
	try { 
		status=msgSignIN.isDisplayed();
		
	}
catch(Exception e) {

}
return status;
}

}