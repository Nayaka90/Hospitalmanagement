package com.hms.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Doc_SpeciallizationPage  {
	@FindBy(name="doctorspecilization")
	private WebElement docspltxtbx;

	@FindBy(name="submit")
	private WebElement sbmtbtn;

	public WebElement getDocspltxtbx() {
		return docspltxtbx;
	}

	public WebElement getSbmtbtn() {
		return sbmtbtn;
	}

	public Doc_SpeciallizationPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
