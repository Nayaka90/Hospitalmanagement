package com.hms.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Doctor_LoginPage {
	@FindBy(name = "username")
	private WebElement usernametxtbx;

	@FindBy(name = "password")
	private WebElement passwordtxtbx;

	@FindBy(name = "submit")
	private WebElement submitbtn;
	
	@FindBy(xpath = "//p/span")
	private WebElement warnMsg;

	public Doctor_LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void doctorLogin(String username,String password) {
		usernametxtbx.sendKeys(username);
		passwordtxtbx.sendKeys(password);
		submitbtn.click();
	}
	
	public WebElement getwarnMsg() {
		return warnMsg;
	}


}
