package Utilities;

import org.testng.annotations.DataProvider;

public class DataProviderAddCourse {
	@DataProvider(name="UserInfo")
	public static Object[][] getData(){
	  	Object[][]arr= new Object[1][6];
	  	arr[0][0]="C:/Users/16097/OneDrive/Desktop/MuKesh_Otwani_Selenium_July2023/javaAsst34.jpg";
	  	arr[0][1]="DevOps Testing";
	  	arr[0][2]="Course duration is 3 moonths.";
	  	arr[0][3]="Rashmi Pal";
	  	arr[0][4]="7000";
	  	arr[0][5]="Selenium";
	  	
	  	arr[0][0]="C:/Users/16097/OneDrive/Desktop/MuKesh_Otwani_Selenium_July2023/databasetesting.jpg";
	  	arr[0][1]="DataBase Testing";
	  	arr[0][2]="Course duration is 2 moonths.";
	  	arr[0][3]="Nancy George";
	  	arr[0][4]="8000";
	  	arr[0][5]="Selenium";
	  	return arr;
}
}
