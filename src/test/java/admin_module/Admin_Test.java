package admin_module;

import org.openqa.selenium.By;
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
		hp.adminLoginClick();
		String un = ful.getDataFromPropertyFile("username");
		String pwd = ful.getDataFromPropertyFile("password");
		Admin_LoginPage al = new Admin_LoginPage(driver);
		Manage_DoctorsPage md = new Manage_DoctorsPage(driver);
		Admin_DashBoardPage ad = new Admin_DashBoardPage(driver);
		Doctor_LoginPage dl = new Doctor_LoginPage(driver);


		al.adminLogin(un, pwd);
		ad.clickingOnMngDoctor();
		String dname = eul.getDataFromExcel(Browser,"AddPat_MngPat", 2, 1);

		driver.findElement(By.xpath("//td[.='" + dname + "']/..//a[@tooltip='Remove']")).click();
		System.out.println(wul.getAlertText(driver));
		wul.acceptAlert(driver);
		ad.logoutLink();
		hp.doctorLoginClick();
		String docmail = eul.getDataFromExcel(Browser,"AddPat_MngPat", 0, 1);
		String password = eul.getDataFromExcel(Browser,"AddPat_MngPat", 1, 1);
		dl.doctorLogin(docmail, password);
		boolean rs = dl.getwarnMsg().isDisplayed();
		if (rs) {
			String color = dl.getwarnMsg().getCssValue("color");
			String t = dl.getwarnMsg().getText();
			System.out.println(color + " " + t);
		}else 
			System.out.println("No warning msg");
		driver.navigate().back();
		driver.navigate().back();
	}

	@Parameters("Browsers") 
	@Test(priority = -1,groups= {"smoke","Regression"})
	public void ManageUSer(@Optional("chrome")String Browser) throws Throwable {
		Home_Page hp;hp= new Home_Page(driver);
		hp.adminLoginClick();
		String un = ful.getDataFromPropertyFile("username");
		String pwd = ful.getDataFromPropertyFile("password");
		Admin_LoginPage al = new Admin_LoginPage(driver);
		al.adminLogin(un, pwd);
		Admin_DashBoardPage ad = new Admin_DashBoardPage(driver);
		ad.clickingOnmanageUser();
		boolean rs = driver.findElement(By.xpath("//td[.='" + eul.getDataFromExcel(Browser,"AddPat_MngPat", 6, 1) + "']")).isDisplayed();
		if (rs)
			System.out.println("Patient detail Dispalyed");
		else
			System.out.println("Patient detail not Dispalyed");

		driver.findElement(By.xpath("//td[text()='" + eul.getDataFromExcel(Browser,"AddPat_MngPat", 6, 1) + "']/..//a[@tooltip='Remove']")).click();
		System.out.println(wul.getAlertText(driver));
		wul.acceptAlert(driver);
		boolean r = driver.findElement(By.xpath("//p")).isDisplayed();
		if (r)
			System.out.println(driver.findElement(By.xpath("//p")).getText());
		else
			System.out.println("not deleted");
		ad.logoutLink();
	}


}
