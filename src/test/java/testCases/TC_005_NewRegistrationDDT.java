package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.DataProviders;
import pageObjects.NewUserRegistrationPage;
import testBase.BaseClass;

@Test (dataProvider="RegistrationData",dataProviderClass=DataProviders.class)
public class TC_005_NewRegistrationDDT extends BaseClass{

	public void RegisterNewUser(String uname, String email,String password,String interest,String gender,String state,String hobbies) {
		logger.info("*** Starting TC_005_NewUserRegistration using DDT Test ***");
		try {
		NewUserRegistrationPage nurp= new NewUserRegistrationPage(driver);
		nurp.clickSignIn();

		nurp.setUserName( uname);
		nurp.setUserEmail(email+"@email.com");
		
		//String password= randomAlphaNumeric() ;
		nurp.setUserPassword(password);
		logger.info("New User: Name,Email,Password entered.");
		nurp.selectIntrest(interest);
		nurp.selectGender(gender);
		nurp.selectDrpState(state);
		nurp.selectDrpHobbies(hobbies);
		logger.info("New User: Intrest,Gender,State and Hobbies entred.");
		nurp.clickSignUp();
		
		boolean status=nurp.signUpMsg();
		Assert.assertTrue(status,"Registration Failed");
		Assert.fail();
		
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("*** Finished TC_005_NewUserRegistration using DDT Test ***");
	}
}
