package com.hms.generic;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.hms.Objectrepository.Admin_DashBoardPage;
import com.hms.Objectrepository.Admin_LoginPage;
import com.hms.Objectrepository.Home_Page;

public class BaseClass {
	public static WebDriver  driver ;
	public DataBaseUtility dul=new DataBaseUtility();
	public ExcelUtility eul = new ExcelUtility();
	public FileUtility ful = new FileUtility();
	public JavaUtility jul = new JavaUtility();
	public WebDriverUtility wul = new WebDriverUtility();
 	static {
 		System.setProperty("webdriver.edge.driver", "./msedgedriver.exe");
 	}
@BeforeSuite(groups= {"smoke","Regression"})
public void configBS() throws Throwable {
	System.out.println("db Connected");
	dul.connectToDB();
}
@BeforeClass(groups= {"smoke","Regression"})
@Parameters("Browsers")
public void configBC(@Optional("chrome")String browser) throws Throwable {
	
	// browser = ful.getDataFromPropertyFile("browsername");

	driver = wul.browserLaunch(driver, browser);
	wul.maximizeWindow(driver);
	wul.waitForPagetoLoad(driver);
	
}
@BeforeMethod(groups= {"smoke","Regression"})
public void configBM() throws Throwable {
	String url = ful.getDataFromPropertyFile("url");
	driver.get(url);
	System.out.println("Login from App");	

}
@AfterMethod(groups= {"smoke","Regression"})
public void configAM() {
System.out.println("Logout from App");	
}
@AfterClass(groups= {"smoke","Regression"})
public void configAC() {
	driver.quit();
}
@AfterSuite(groups= {"smoke","Regression"})
public void configAS() throws Throwable {
	dul.dissconnectDB();
	System.out.println("db DisConnected");

}
}
