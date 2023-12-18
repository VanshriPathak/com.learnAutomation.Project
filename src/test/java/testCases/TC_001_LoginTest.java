package testCases;

import org.testng.annotations.Test;



import org.testng.Assert;

import pageObjects.LoginPage;
import pageObjects.HomePage;
import testBase.BaseClass;
public class TC_001_LoginTest extends BaseClass {

	
	
	@Test (groups= {"Regression","Master"})
	public void validTtest() {
		try{
			logger.info("*** Starting TC_001_LoginTest ***");
		LoginPage lp= new LoginPage(driver);
		//without config.properties
		//lp.setUsername ("admin@email.com");
		//lp.setPassword("admin@123") ;
		
		//with config.properties
		lp.setUsername (rb.getString("email"));
		lp.setPassword(rb.getString("password")) ;
		lp.clickSignIn();
		logger.info("Login UserName and Password is entered and Clicked on SignIN button.");
		HomePage hp=new HomePage(driver);
		
		Assert.assertTrue(hp.isManageDisplayed());
		logger.info("Login for user is sucessful.");
		hp.signOutFromApplication();
	
		Assert.assertTrue(lp.isSignInDisplayed());
		logger.info("SignOut for user is done sucessfully.");
		
		
	}catch(Exception e){
		Assert.fail();
	}
		logger.info("*** Finish Execution of TC_001_LoginTest ***");
	}
}
