package com.hms.Objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import com.hms.generic.ExcelUtility;
import com.hms.generic.WebDriverUtility;

public class Add_PatientPage extends WebDriverUtility {
	@FindBy(name = "patname")
	private WebElement patNameTxtBx;

	@FindBy(name = "patcontact")
	private WebElement patCntctTxtBx;

	@FindBy(name = "patemail")
	private WebElement patemailTxtBx;
	
	@FindBy(name = "pataddress")
	private WebElement pataddressTxtBx;
	
	@FindBy(name = "patage")
	private WebElement patageTxtBx;
	
	@FindBy(name = "medhis")
	private WebElement medhisTxtBx;
		
	@FindBy(name = "submit")
	private WebElement submitBtn;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement updateBtn;
	
	public Add_PatientPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	
	
	public void addPatient(String Browser,WebDriver driver,ExcelUtility eul) throws Throwable {
		patNameTxtBx.sendKeys(eul.getDataFromExcel(Browser,"AddPat_MngPat", 6, 1));
		patCntctTxtBx.sendKeys(eul.getDataFromExcel(Browser,"AddPat_MngPat", 7, 1));
		patemailTxtBx.sendKeys(eul.getDataFromExcel(Browser,"AddPat_MngPat", 4, 1));
		pataddressTxtBx.sendKeys(eul.getDataFromExcel(Browser,"AddPat_MngPat", 9, 1));
		patageTxtBx.sendKeys(eul.getDataFromExcel(Browser,"AddPat_MngPat", 10, 1));
		medhisTxtBx.sendKeys(eul.getDataFromExcel(Browser,"AddPat_MngPat", 11, 1));
		driver.findElement(By.xpath(" //label[normalize-space()='"+eul.getDataFromExcel(Browser,"AddPat_MngPat", 8, 1)+"']")).click();
		submitBtn.click();
	}
     public void Update() {
    	 updateBtn.click();
     }
}
