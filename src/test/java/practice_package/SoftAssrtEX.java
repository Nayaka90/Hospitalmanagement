package practice_package;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hms.generic.WebDriverUtility;

public class SoftAssrtEX {
	@Test
	public  void main() {
		WebDriverUtility w=new WebDriverUtility();
		WebDriver driver =null;
		driver=w.browserLaunch(driver, "chrome");
		driver.get("http://rmgtestingserver/domain/Hospital_Management_System/hms/doctor/");
		String t = driver.getTitle();
		Assert.assertTrue(t.contains("Login"),"Fail Because Required Page is not displayed");
		WebElement un = driver.findElement(By.name("username"));
		WebElement pwd = driver.findElement(By.name("password"));

		SoftAssert sa=new SoftAssert();
		Rectangle un1 = pwd.getRect();
		Rectangle pwd1 = un.getRect();
		int unHt = un1.getHeight();
		int pwdHt = pwd1.getHeight();
		int unwdth = un1.getWidth();
		int pwdwdth = pwd1.getWidth();
		String a = un.getAttribute("placeholder");
		sa.assertEquals(a, "usermail");
		String b = pwd.getAttribute("placeholder");
		sa.assertEquals(b, "Password");
		sa.assertEquals(unwdth, pwdHt);
		sa.assertEquals(unHt, pwdwdth);
		sa.assertAll();



	}

}
