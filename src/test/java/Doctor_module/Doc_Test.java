package Doctor_module;

import org.openqa.selenium.By;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hms.Objectrepository.Add_PatientPage;
import com.hms.Objectrepository.Admin_DashBoardPage;
import com.hms.Objectrepository.Admin_LoginPage;
import com.hms.Objectrepository.Doctor_DashboardPage;
import com.hms.Objectrepository.Doctor_LoginPage;
import com.hms.Objectrepository.Home_Page;
import com.hms.Objectrepository.Manage_PatientPage;
import com.hms.Objectrepository.Medical_HistoryPage;
import com.hms.Objectrepository.Patient_DashboardPage;
import com.hms.Objectrepository.Patient_LoginPage;
import com.hms.generic.BaseClass;

public class Doc_Test extends BaseClass{
	@Parameters("Browsers") 
	 @Test(priority = -4,groups= {"smoke","Regression"})
		public  void addPatient_mgePatientTest(@Optional("chrome")String Browser ) throws Throwable {
			Home_Page hp = new Home_Page(driver);
			Doctor_LoginPage dl = new Doctor_LoginPage(driver);
			Doctor_DashboardPage dd = new Doctor_DashboardPage(driver);
			Add_PatientPage ap = new Add_PatientPage(driver);
			Admin_LoginPage al = new Admin_LoginPage(driver);
			Admin_DashBoardPage ad = new Admin_DashBoardPage(driver);

			String docmail = eul.getDataFromExcel(Browser,"AddPat_MngPat", 0, 1);
			String pwd = eul.getDataFromExcel(Browser,"AddPat_MngPat", 1, 1);

			hp.doctorLoginClick();
			dl.doctorLogin(docmail, pwd);

			dd.clickingOnaddPatietlink();
			ap.addPatient(Browser,driver, eul);
			dd.logoutLink();
			hp.adminLoginClick();
			String un = ful.getDataFromPropertyFile("username");
			String password = ful.getDataFromPropertyFile("password");
			al.adminLogin(un, password);
			ad.clickingOnmanagePatient();
			try {
				boolean rs = driver.findElement(By.xpath("//td[.='" + eul.getDataFromExcel(Browser,"AddPat_MngPat", 6, 1) + "']"))
						.isDisplayed();
				if (rs) {
					System.out.println("Patient details displayed");

				} else {
					System.out.println("Patient details not displayed");
				}
			} catch (Exception e) {
				System.out.println("Patient name not Present");
			}
			dd.logoutLink();
		}
	@Parameters("Browsers") 
	 @Test(priority = -3,groups= {"smoke","Regression"})
		public void generateReport(@Optional("chrome")String Browser) throws Throwable {
			Home_Page hp = new Home_Page(driver);
			Doctor_LoginPage dl = new Doctor_LoginPage(driver);
			Doctor_DashboardPage dd = new Doctor_DashboardPage(driver);
			Manage_PatientPage mp = new Manage_PatientPage(driver);
			Add_PatientPage ap = new Add_PatientPage(driver);
			Patient_LoginPage pl = new Patient_LoginPage(driver);
			Patient_DashboardPage pd = new Patient_DashboardPage(driver);
			Medical_HistoryPage mh = new Medical_HistoryPage(driver);

			String docmail = eul.getDataFromExcel(Browser,"AddPat_MngPat", 0, 1);
			String pwd = eul.getDataFromExcel(Browser,"AddPat_MngPat", 1, 1);

			hp.doctorLoginClick();
			dl.doctorLogin(docmail, pwd);
			dd.clickOnSearhIcon();
			mp.pdatingpatientMedicalHis(Browser,eul);
			System.out.println(wul.getAlertText(driver));
			wul.acceptAlert(driver);
			dd.logoutLink();
			hp.patientLoginClick();
			pl.patientLogin(Browser,eul);
			pd.clickingOnmedHistory();
			String text = mh.verifyingMedHistory(eul);

			if (text.equals(eul.getDataFromExcel(Browser,"AddPat_MngPat", 13, 1)))
				System.out.println("Medical history Displayed");
			else
				System.out.println("Medical history not Displayed");
			pd.logoutLink();
		}
	

}
