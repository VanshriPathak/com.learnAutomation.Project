package testBase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;
import org.openqa.selenium.TakesScreenshot;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;




public class BaseClass {
public static WebDriver driver;
public Logger logger; 
public ResourceBundle rb; // declaration for reading config.properties
	
	@BeforeClass (groups= {"Regression","Master","Sanity"})
	@Parameters("browser")//getting browser from testNg.xml
	public void setUp(String br)
	
	{	
		rb=ResourceBundle.getBundle("config");//load config.properties
		
		logger=LogManager.getLogger(this.getClass());
		//Launch browser based on parameter entered from testng.xml file
		if(br.equals("chrome")) {
			driver = new ChromeDriver();
			logger.info("Chrome Driver is started");
		}
		else if(br.equals("firefox")) {
			driver = new FirefoxDriver();
			logger.info("Firefox Driver is started");
		}
		else if(br.equals("edge")) {
			driver = new EdgeDriver();
			logger.info("Edge Driver is started");
		}
		else if(br.equals("safari")) {
			driver = new SafariDriver();
			logger.info("Safari Driver is started");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		//without config.properties
		//driver.get("https://freelance-learn-automation.vercel.app/login");
		
		//with config.properties 
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
	
	}
	
	
	@AfterClass (groups= {"Regression","Master","Sanity"})
	public void tearDown() {
		driver.close();
	}
	
	public String randomeString() {
		String generatedString= RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public String randomeNumber() {
		String generatedString2= RandomStringUtils.randomNumeric(10);
		return generatedString2;
	}
	public String randomAlphaNumeric() {
		String st= RandomStringUtils.randomAlphabetic(4);
		String num= RandomStringUtils.randomNumeric(4);
		return (st+"@"+num);
	}
	
	public String captureScreen(String tname) throws IOException{
		String timeStamp = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("./screenshots")+tname+"_"+timeStamp+".png" ;
		///Users/adityapathak/Desktop/EclipseWorkspace/com.learnAutomation/screenshots
		try {
			FileUtils.copyFile(src,new File(destination));
		}catch(Exception e) {
			e.getMessage();
		}
		logger.info("ScreenShot taken for failed TC and saved under screenshots folder.");
		return destination;
	}
	
}
