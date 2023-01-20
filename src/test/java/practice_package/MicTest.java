package practice_package;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MicTest {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		// connectSetting.put("notifications", 2);
		// connectSetting.put("geolocation", 2);

		HashMap<String, Integer> connectSetting = new HashMap<String, Integer>();
		HashMap<String, Object> profile = new HashMap<String, Object>();
		HashMap<String, Object> prefs = new HashMap<String, Object>();

		connectSetting.put("media_stream", 1);
		profile.put("managed_default_content_settings", connectSetting);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://mictests.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[.='Test my mic']")).click();

		for(;;)
		{try {
	driver.findElement(By.xpath("//li[@class='notice-loading loading_testingMic']//b"));
		}
		catch (Exception e) {
			String text = driver.findElement(By.xpath("//ul[@id='mic-notices']")).getText();
			System.out.println(text);
			break;
			}
		}
		driver.close();
		
	}
}
