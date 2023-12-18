package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import pageObjects.NewUserRegistrationPage;
import testBase.BaseClass;

public class TC_002_NewUserRegistrationTest extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
private void RegisterUser() {
		logger.info("*** Starting TC_002_NewUserRegistrationTest ***");
	try {
	NewUserRegistrationPage nurp= new NewUserRegistrationPage(driver);
	
	nurp.clickSignIn();

	nurp.setUserName( randomeString().toUpperCase());
	nurp.setUserEmail(randomeString()+"@email.com");
	
	//String password= randomAlphaNumeric() ;
	nurp.setUserPassword(randomAlphaNumeric());
	logger.info("New User: Name,Email,Password entered.");
	nurp.selectIntrest("Java");
	nurp.selectGender("Female");
	nurp.selectDrpState("Maharashtra");
	nurp.selectDrpHobbies("Playing");
	logger.info("New User: Intrest,Gender,State and Hobbies entred.");
	nurp.clickSignUp();
	
	boolean status=nurp.signUpMsg();
	Assert.assertTrue(status,"Registration Failed");
	logger.info("*** Finished TC_002_NewUserRegistrationTest ***");
	}catch(Exception e) {
		Assert.fail();
	}
logger.info("*** Finished TC_002_NewUserRegistrationTest ***");
	}
}
