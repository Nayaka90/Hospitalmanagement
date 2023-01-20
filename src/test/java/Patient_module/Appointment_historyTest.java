package Patient_module;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hms.Objectrepository.Add_DoctorPage;
import com.hms.Objectrepository.Admin_DashBoardPage;
import com.hms.Objectrepository.Admin_LoginPage;
import com.hms.Objectrepository.Book_ApointmentPage;
import com.hms.Objectrepository.Doctor_LoginPage;
import com.hms.Objectrepository.Home_Page;
import com.hms.Objectrepository.Manage_DoctorsPage;
import com.hms.Objectrepository.Patient_DashboardPage;
import com.hms.Objectrepository.Patient_LoginPage;
import com.hms.Objectrepository.Patient_RegPage;
import com.hms.generic.BaseClass;
import com.hms.generic.ExcelUtility;
import com.hms.generic.FileUtility;
import com.hms.generic.JavaUtility;
import com.hms.generic.WebDriverUtility;

public class Appointment_historyTest extends BaseClass {
	
	@Parameters("Browsers") 
	@Test(priority=-5,groups="smoke")
	public void  appointment_historyTest(@Optional("chrome")String Browser) throws Throwable {

		Manage_DoctorsPage md = new Manage_DoctorsPage(driver);
		Add_DoctorPage ado = new Add_DoctorPage(driver);
		Patient_LoginPage pl = new Patient_LoginPage(driver);
		Patient_RegPage pr = new Patient_RegPage(driver);
		Patient_DashboardPage pd = new Patient_DashboardPage(driver);
		Book_ApointmentPage ba = new Book_ApointmentPage(driver);
		Admin_DashBoardPage ad = new Admin_DashBoardPage(driver);
		Home_Page hp= new Home_Page(driver);
		Admin_LoginPage al = new Admin_LoginPage(driver);

		String un = ful.getDataFromPropertyFile("username");
		String pwd = ful.getDataFromPropertyFile("password");
		hp.adminLoginClick();
		al.adminLogin(un, pwd);
		ad.clickingOnAddDoctor();
		ado.addDoctor(Browser,eul, jul);
		System.out.println(wul.getAlertText(driver));
		wul.acceptAlert(driver);
		String dname = eul.getDataFromExcel(Browser,"AddPat_MngPat", 2, 1);
		String ns = jul.getSystemDateWithFormat();

		try {
			boolean rs = driver
					.findElement(
							By.xpath(" //td[.='" + dname + "']/following-sibling::td[contains(text(),'" + ns + "')] "))
					.isDisplayed();
			if (rs)
				System.out.println("Doctor profile dispalyed");
			else
				System.out.println("Doctor profile not dispalyed");

		} catch (Exception e) {
			System.out.println("Element not present");
		}

		ad.logoutLink();
		hp.patientLoginClick();
		pl.createacntlink();
		pr.patientReg(Browser,eul, jul, driver);
		System.out.println(wul.getAlertText(driver));
		wul.acceptAlert(driver);
		pr.loginlink();
		pl.patientLogin(Browser,eul);
		pd.clickingOnBookApmt();
		String d = jul.getSystemDateWithFormat();
		eul.setDataToExcel(Browser,"Add_Pat", 0, 5, d);
		ba.clickingOnBookApmt(Browser,eul);
		System.out.println(wul.getAlertText(driver));
		wul.acceptAlert(driver);
		pd.logoutLink();
		hp.adminLoginClick();
		al.adminLogin(un, pwd);
		ad.clickingOnAptmtHistory();
		String txt = driver.findElement(By.xpath("//td[.='" + dname + "']/following-sibling::td[6]")).getText();
		if (txt.contains("Active"))
			System.out.println("OK");
		else
			System.out.println("not ok");
		ad.logoutLink();
	}	
}

















