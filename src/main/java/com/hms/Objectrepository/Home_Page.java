package com.hms.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	@FindBy(xpath = "//h3[text()='Admin Login']/following-sibling::div//a")
	private WebElement adminloginlink;

	@FindBy(xpath = "//h3[text()='Doctors Login']/..//a[.='Click Here']")
	private WebElement docloginlink;

	@FindBy(xpath = "//h3[.='Patients']/..//a[.='Click Here']")
	private WebElement patloginlink;

	@FindBy(xpath = "//a[.='Home']")
	private WebElement HomePglink;

	@FindBy(xpath = "//a[.='contact']")
	private WebElement cntctuslink;

	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void doctorLoginClick() {
		docloginlink.click();
	}

	public void patientLoginClick() {
		patloginlink.click();
	}

	public void adminLoginClick() {
		adminloginlink.click();
	}

	public void homePageClick() {
		HomePglink.click();
	}

	public void ContctusClick() {
		cntctuslink.click();
	}

}
