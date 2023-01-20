package com.hms.Objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import com.hms.generic.ExcelUtility;
import com.hms.generic.JavaUtility;
import com.hms.generic.WebDriverUtility;

public class Patient_RegPage extends WebDriverUtility{
	@FindBy(name = "full_name")
	private WebElement nametxtbx;
	
	@FindBy(name = "address")
	private WebElement addresstxtbx;
	
	@FindBy(name = "city")
	private WebElement citytxtbx;
	
	@FindBy(name = "email")
	private WebElement emailtxtbx;
	
	@FindBy(name = "password")
	private WebElement pwdtxtbx;
	
	@FindBy(name = "password_again")
	private WebElement cnfpwdtxtbx;
	
	@FindBy(name = "submit")
	private WebElement sbmtbtn;
	
	@FindBy(xpath="//label[normalize-space()='Male']")
	private WebElement MaleradioBtn;
	
	@FindBy(xpath="//label[normalize-space()='Female']")
	private WebElement FemaleradioBtn;
	
	
	@FindBy(partialLinkText = "Log-in")
	private WebElement lgnlink;
	
	public Patient_RegPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void patientReg(String Browser,ExcelUtility eul,JavaUtility jul,WebDriver driver) throws Throwable {
		String pname = eul.getDataFromExcel(Browser,"Add_Pat", 0, 1)+jul.getRandomAlphabet();
		nametxtbx.sendKeys(pname);		
		addresstxtbx.sendKeys(eul.getDataFromExcel(Browser,"Add_Pat", 1, 1));
		citytxtbx.sendKeys(eul.getDataFromExcel(Browser,"Add_Pat", 2, 1));
		String pmail=pname+jul.getRandomNumber()+eul.getDataFromExcel(Browser,"Add_Pat", 3, 1);
		emailtxtbx.sendKeys(pmail);
		driver.findElement(By.xpath("//label[normalize-space()='"+eul.getDataFromExcel(Browser,"Add_Pat", 6, 1)+"']")).click();
		pwdtxtbx.sendKeys(eul.getDataFromExcel(Browser,"Add_Pat", 4, 1));
		String pwd=eul.getDataFromExcel(Browser,"Add_Pat", 5, 1);
		cnfpwdtxtbx.sendKeys(pwd);
		eul.setDataToExcel(Browser,"AddPat_MngPat", 6, 1, pname);	
		eul.setDataToExcel(Browser,"AddPat_MngPat", 4, 1, pmail);
		eul.setDataToExcel(Browser,"AddPat_MngPat", 5, 1, pwd);
		sbmtbtn.click();	
	}
	
	public void loginlink()
	{
		lgnlink.click();
	}
	
	

}
