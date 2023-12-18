package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Utilities.DataProviders;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_004_LoginTestDDT extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_login(String uname, String password,String exp) {
		
			logger.info("***TC_004_LOginTestDDT is strarted***.");
			try{
		LoginPage lp= new LoginPage(driver);
		
		lp.setUsername (uname);
		lp.setPassword(password) ;
		lp.clickSignIn();
		logger.info("Login UserName and Password is entered and Clicked on SignIN button.");
		
		HomePage hp=new HomePage(driver);
		boolean targetPage= hp.isManageDisplayed();
		
		logger.info("Login for user is sucessful.");
		
		if(exp.equals("Valid")) {
			if(targetPage==true) {
				hp.signOutFromApplication();//logout as login is successful
				Assert.assertTrue(true);
			}
		}
		if(exp.equals("Invalid")) {
			if(targetPage==true) {
				hp.signOutFromApplication();//logout as login is successful
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
	}catch(Exception e){
			Assert.fail();
		}
	
		//Assert.assertTrue(lp.isSignInDisplayed());
		logger.info("*** TC_004_LoginTestDDT is Finished***");
		
	}
	

}
