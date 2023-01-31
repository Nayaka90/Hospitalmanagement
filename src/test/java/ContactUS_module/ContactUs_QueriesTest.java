package ContactUS_module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hms.Objectrepository.Admin_DashBoardPage;
import com.hms.Objectrepository.Admin_LoginPage;
import com.hms.Objectrepository.ContactUs_Page;
import com.hms.Objectrepository.Home_Page;
import com.hms.Objectrepository.Query_DetailsPage;
import com.hms.generic.BaseClass;
import com.hms.generic.ExcelUtility;
import com.hms.generic.FileUtility;
import com.hms.generic.JavaUtility;
import com.hms.generic.WebDriverUtility;
 
public class ContactUs_QueriesTest extends BaseClass {
	
	@Parameters("Browsers")
    @Test(groups= "Regression")
	public void  contactUs_QueriesTest(@Optional("chrome")String Browser) throws Throwable {
	    String un = ful.getDataFromPropertyFile("username");
		String pwd = ful.getDataFromPropertyFile("password");
		Home_Page hp = new Home_Page(driver);
		ContactUs_Page cp =new ContactUs_Page(driver);
		Admin_LoginPage al=new Admin_LoginPage(driver);
		Admin_DashBoardPage ad= new Admin_DashBoardPage(driver);
		Query_DetailsPage qd=new Query_DetailsPage(driver);
		
		wul.waitForPageTitle(driver, "Home");
		Assert.assertTrue(driver.getTitle().contains("Home"),"Homepage is not displayed");
		hp.ContctusClick();
		
		wul.waitForPageTitle(driver, "contact");
		Assert.assertTrue(driver.getTitle().contains("contact"),"Contactuspage is not displayed");
		cp.contactusQuery(Browser,eul);
		System.out.println(wul.getAlertText(driver));
		wul.acceptAlert(driver);
		hp.homePageClick();
		
		wul.waitForPageTitle(driver, "Home");
		hp.adminLoginClick();
		
		wul.waitForPageTitle(driver, "Login");	
		al.adminLogin(un, pwd);
		
		wul.waitForPageTitle(driver, "Dashboard");
		ad.clickingOnUnReadQuery();
		
		wul.waitForPageTitle(driver, "Details");
		driver.findElement(By.xpath("//td[.='"+eul.getDataFromExcel(Browser,"ContactUs_Queries", 1, 1)+"']/..//a[@title='View Details']")).click();
		qd.adminRemark(Browser,eul);
		System.out.println( wul.getAlertText(driver));
		wul.acceptAlert(driver);
		boolean rs = driver.findElement(By.xpath("//td[.='"+eul.getDataFromExcel(Browser,"ContactUs_Queries", 1, 1)+"']")).isDisplayed();
//		if (rs) 
//			System.out.println("Updated");
//		else 
//			System.out.println("not updated");
		ad.logoutLink();
		Assert.assertTrue(rs,"remarks updated");

	}

}
