package com.hms.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import com.hms.generic.ExcelUtility;

public class Manage_PatientPage {
	@FindBy(name = "searchdata")
	private WebElement searchTxtBx;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchBtn;

	@FindBy(xpath = "//i[@class='fa fa-eye']")
	private WebElement eyeIcon;

	@FindBy(xpath = "//button[.='Add Medical History']")
	private WebElement addMedicalHisBtn;

	@FindBy(name = "bp")
	private WebElement BloodPressuretxtBX;

	@FindBy(name = "bs")
	private WebElement BloodSugartxtBX;

	@FindBy(name = "weight")
	private WebElement weighttxtBX;

	@FindBy(name = "temp")
	private WebElement bodyTempTxtBX;

	@FindBy(name = "pres")
	private WebElement prescTxtBX;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submtBtn;

	@FindBy(xpath = "//span[@class='username']")
	private WebElement profiledropdown;

	@FindBy(linkText = "Log Out")
	private WebElement lgoutlink;

	public Manage_PatientPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void pdatingpatientMedicalHis(String Browser,ExcelUtility eul) throws Throwable {
		searchTxtBx.sendKeys(eul.getDataFromExcel(Browser,"AddPat_MngPat", 6, 1));
		searchBtn.click();
		eyeIcon.click();
		addMedicalHisBtn.click();
		BloodPressuretxtBX.sendKeys(eul.getDataFromExcel(Browser,"AddPat_MngPat", 13, 1));
		BloodSugartxtBX.sendKeys(eul.getDataFromExcel(Browser,"AddPat_MngPat", 14, 1));
		weighttxtBX.sendKeys(eul.getDataFromExcel(Browser,"AddPat_MngPat", 15, 1));
		bodyTempTxtBX.sendKeys(eul.getDataFromExcel(Browser,"AddPat_MngPat", 16, 1));
		prescTxtBX.sendKeys(eul.getDataFromExcel(Browser,"AddPat_MngPat", 17, 1));
		submtBtn.click();

	}

}
