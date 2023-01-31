package admin_module;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hms.Objectrepository.Admin_DashBoardPage;
import com.hms.Objectrepository.Admin_LoginPage;
import com.hms.Objectrepository.Doctor_LoginPage;
import com.hms.Objectrepository.Home_Page;
import com.hms.Objectrepository.Manage_DoctorsPage;
import com.hms.generic.BaseClass;

public class Admin_Test extends BaseClass{
	@Parameters("Browsers") 
	@Test(priority = -2,groups ="smoke")
	public void Manage_doc(@Optional("chrome")String Browser) throws Throwable {
		Home_Page hp= new Home_Page(driver);
		Admin_LoginPage al = new Admin_LoginPage(driver);
		Manage_DoctorsPage md = new Manage_DoctorsPage(driver);
		Admin_DashBoardPage ad = new Admin_DashBoardPage(driver);
		Doctor_LoginPage dl = new Doctor_LoginPage(driver);

		wul.waitForPageTitle(driver, "Home");
		hp.adminLoginClick();
		String un = ful.getDataFromPropertyFile("username");
		String pwd = ful.getDataFromPropertyFile("password");

		wul.waitForPageTitle(driver, "Login");
		al.adminLogin(un, pwd);

		wul.waitForPageTitle(driver, "Dashboard");
		ad.clickingOnMngDoctor();

		wul.waitForPageTitle(driver, "Manage");
		String dname = eul.getDataFromExcel(Browser,"AddPat_MngPat", 2, 1);
		driver.findElement(By.xpath("//td[.='" + dname + "']/..//a[@tooltip='Remove']")).click();
		System.out.println(wul.getAlertText(driver));
		wul.acceptAlert(driver);
		ad.logoutLink();

		wul.waitForPageTitle(driver, "Home");
		hp.doctorLoginClick();
		String docmail = eul.getDataFromExcel(Browser,"AddPat_MngPat", 0, 1);
		String password = eul.getDataFromExcel(Browser,"AddPat_MngPat", 1, 1);

		wul.waitForPageTitle(driver, "Login");
		dl.doctorLogin(docmail, password);
		boolean rs = dl.getwarnMsg().isDisplayed();

		driver.navigate().back();
		driver.navigate().back();	

		//		if (rs) {
		//			String color = dl.getwarnMsg().getCssValue("color");
		//			String t = dl.getwarnMsg().getText();
		//			System.out.println(color + " " + t);
		//		}else 
		//			System.out.println("No warning msg");
		Assert.assertTrue(rs,"Warning msg not displayed ");


	}

	@Parameters("Browsers") 
	@Test(priority = -1,groups= {"smoke","Regression"})
	public void ManageUSer(@Optional("chrome")String Browser) throws Throwable {
		wul.waitForPageTitle(driver, "Home");
		
		Home_Page hp= new Home_Page(driver);
		Admin_DashBoardPage ad = new Admin_DashBoardPage(driver);
		String un = ful.getDataFromPropertyFile("username");
		String pwd = ful.getDataFromPropertyFile("password");
		Admin_LoginPage al = new Admin_LoginPage(driver);
		
		hp.adminLoginClick();
		wul.waitForPageTitle(driver, "Login");
		
		al.adminLogin(un, pwd);
		wul.waitForPageTitle(driver, "Dashboard");
		ad.clickingOnmanageUser();
		
		wul.waitForPageTitle(driver, "Manage");
		boolean rs = driver.findElement(By.xpath("//td[.='" + eul.getDataFromExcel(Browser,"AddPat_MngPat", 6, 1) + "']")).isDisplayed();
		Assert.assertTrue(rs,"Patient detail not Dispalyed");
		//		if (rs)
		//			System.out.println("Patient detail Dispalyed");
		//		else
		//			System.out.println("Patient detail not Dispalyed");

		driver.findElement(By.xpath("//td[text()='" + eul.getDataFromExcel(Browser,"AddPat_MngPat", 6, 1) + "']/..//a[@tooltip='Remove']")).click();
		System.out.println(wul.getAlertText(driver));
		wul.acceptAlert(driver);
		boolean r = driver.findElement(By.xpath("//p")).isDisplayed();

		//		if (r)
		//			System.out.println(driver.findElement(By.xpath("//p")).getText());
		//		else
		//			System.out.println("not deleted");
		ad.logoutLink();
		Assert.assertTrue(r,"not deleted");
	}


}
