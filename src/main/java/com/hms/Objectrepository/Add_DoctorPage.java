package com.hms.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.generic.ExcelUtility;
import com.hms.generic.JavaUtility;
import com.hms.generic.WebDriverUtility;

public class Add_DoctorPage extends WebDriverUtility{
	@FindBy(name = "Doctorspecialization")
	private WebElement docspllistbx;

	@FindBy(name = "docname")
	private WebElement docnametxtbx;

	@FindBy(name = "clinicaddress")
	private WebElement clinicaddresstxtbx;

	@FindBy(name = "docfees")
	private WebElement docfeestxtbx;

	@FindBy(name = "doccontact")
	private WebElement doccontacttxtbx;

	@FindBy(name = "docemail")
	private WebElement docemailtxtbx;

	@FindBy(name = "npass")
	private WebElement pwdtxtbx;

	@FindBy(name = "cfpass")
	private WebElement cnfpwdtxtbx;

	@FindBy(name = "submit")
	private WebElement submitbtn;

	public Add_DoctorPage (WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void addDoctor(String Browser,ExcelUtility eul,JavaUtility jul ) throws Throwable {
		String docspl = eul.getDataFromExcel(Browser,"Add_doct", 0, 1);
		select(docspllistbx,docspl);
		String docname=eul.getDataFromExcel(Browser,"Add_doct", 1, 1)+jul.getRandomAlphabet();
		docnametxtbx.sendKeys(docname);
		clinicaddresstxtbx.sendKeys(eul.getDataFromExcel(Browser,"Add_doct", 2, 1));
		docfeestxtbx.sendKeys(eul.getDataFromExcel(Browser,"Add_doct", 3, 1));
		doccontacttxtbx.sendKeys(eul.getDataFromExcel(Browser,"Add_doct", 4, 1));
		String docmail = eul.getDataFromExcel(Browser,"Add_doct", 5, 1)+jul.getRandomNumber()+eul.getDataFromExcel(Browser,"Add_doct", 5, 2);
		docemailtxtbx.sendKeys(docmail);
		pwdtxtbx.sendKeys(eul.getDataFromExcel(Browser,"Add_doct", 6, 1));
		String pwd = eul.getDataFromExcel(Browser,"Add_doct", 7, 1);
		cnfpwdtxtbx.sendKeys(pwd);
		eul.setDataToExcel(Browser,"AddPat_MngPat", 0, 1, docmail);
		eul.setDataToExcel(Browser,"AddPat_MngPat", 1, 1,pwd);
		eul.setDataToExcel(Browser,"AddPat_MngPat", 2, 1,docname);
		eul.setDataToExcel(Browser,"AddPat_MngPat", 3, 1,docspl);
		submitbtn.click();
	}
}
