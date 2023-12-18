package Utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {

	//DataProvider 1

	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path="/Users/adityapathak/Desktop/EclipseWorkspace/com.learnAutomation/testData/LearnAutomation_LoginData.xlsx";//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return logindata;//returning two dimension array
				
	}
	
	//DataProvider 2
	@DataProvider(name="RegistrationData")
	public Object[][] getDataRegistration() throws IOException
	{
		String path="/Users/adityapathak/Desktop/EclipseWorkspace/com.learnAutomation/testData/LearnAutomation_LoginData.xlsx";//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet2");	
		int totalcols=xlutil.getCellCount("Sheet2",1);
		System.out.println(totalrows +"  "+ totalcols);
				
	Object RegistrationData[][]=new Object[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=0;i<totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				//String valueString="";
				//CellType type=xlutil.getCellData("Sheet2",i, j").getCellType();
					
				RegistrationData[i][j]= xlutil.getCellData("Sheet2",i, j);  //1,0
				System.out.println(RegistrationData[i][j]);
			}
		}
	return RegistrationData;//returning two dimension array
				
	}
	//DataProvider 3
	
	//DataProvider 4
}
