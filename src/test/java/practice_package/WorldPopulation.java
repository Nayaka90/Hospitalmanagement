package practice_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorldPopulation {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.worldometers.info/world-population/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String text=driver.findElement(By.xpath("//span[@rel='current_population']")).getText();
		System.out.println(text);
	}

}
