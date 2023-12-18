package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class AddCoursePage extends BasePage {

	public AddCoursePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy (xpath="//button[text()='Add New Course ']")
	WebElement lnkAddCourse;
	
	@FindBy (xpath="//input[@type='file']")
	WebElement btnChooseFile ;
	
	@FindBy (xpath="//input[@id='name']")
	WebElement txtCourseName;
	
	@FindBy (xpath="//textarea[@id='description']")
	WebElement txtCourseDesc;
	
	@FindBy (xpath="//input[@id='instructorNameId']")
	WebElement txtCourseInst;
	
	@FindBy (xpath="//input[@id='price']")
	WebElement txtCourseFees;
	
	@FindBy (xpath="//input[@name='startDate']")
	WebElement txtStartDate;
	
	@FindBy (xpath="//input[@name='endDate']")
	WebElement txtEndDate;
	
	@FindBy (id="isPermanent")
	WebElement chkbox ;
	
	@FindBy (xpath="//div[text()='Select Category']")
	WebElement category;
	
	@FindBy (xpath="//button[@class='action-btn']")
	WebElement btnSave;

	
	public void addCourse(String fpath,String cName,String cDescr,String cInst,String cFees,String cCategory) throws InterruptedException {
		
		lnkAddCourse.click();
		
		wait(btnChooseFile);
		Thread.sleep(3000);
		//I have to use data Provider 
		//Upload image
		WebElement fileInput = btnChooseFile;
		fileInput.sendKeys(fpath);//fpath is from my array 2D
		Thread.sleep(3000);
		wait(txtCourseName);
		txtCourseName.sendKeys(cName);
		txtCourseDesc.sendKeys(cDescr);
		txtCourseInst.sendKeys(cInst);
		txtCourseFees.sendKeys( cFees);
		//start date Nov 8
		wait(txtStartDate);
		txtStartDate.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='8']")).click();
		//end date Dec 8
		wait(txtEndDate);
		txtEndDate.click();
		driver.findElement(By.xpath("//div[text()='8']")).click();
		Thread.sleep(3000);
	//checkbox
		chkbox.click();
		wait(category);
		category.click();
		Thread.sleep(3000);
		//
		List<WebElement> list=driver.findElements(By.xpath("//button[@class='menu-item']"));
		for(WebElement e:list) {
			String text1=e.getText();
			if(text1.equalsIgnoreCase(cCategory)) {
				e.click();
				break;
		}
		}
		Thread.sleep(3000);
		// save button
		btnSave.click();
		
	}
	
}
