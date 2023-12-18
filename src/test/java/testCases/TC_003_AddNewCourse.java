package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;
import pageObjects.LoginPage;
import pageObjects.HomePage;
import pageObjects.AddCoursePage;
public class TC_003_AddNewCourse extends BaseClass{

	@Test (groups= {"Regression"})
	public void addCourse () throws InterruptedException {
		logger.info("***Strating TC_003_AddNewCourse ****");
		try {
		LoginPage lp= new LoginPage(driver);
		lp.setUsername(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		lp.clickSignIn();
		logger.info("Login Username, Password entered.");
		
		
		HomePage hp= new HomePage(driver);
		Assert.assertTrue(hp.isManageDisplayed());
		logger.info("Login is validated or Login done Sucessful");
		hp.selectManageCourse();
		logger.info("On Homepage link ManageCourses is clicked.");
	
		AddCoursePage acp= new AddCoursePage(driver);
		acp.addCourse("/Users/adityapathak/Desktop/image1.jpg","API Testing","Course duration is 3 months.","Rashmi Pal","7000","Java");
		logger.info("On Homepage link ManageCourses is clicked.");
		}catch(Exception e){
			Assert.fail();
		}
		logger.info("***Finished TC_003_AddNewCourse ****");
	}
}
