package practice_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class magento {

	public static void main(String ar[]) {
		
		WebDriver d=new ChromeDriver();
		// ((JavascriptExecutor)d).executeScript("");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		d.get("https://magento2.algolia.com/women.html");
		WebElement x = d.findElement(By.xpath("//a[.='Women']"));
		WebElement y = d.findElement(By.xpath("//span[.='Women']/../../ul//span[.='Tops']"));
		WebElement z = d.findElement(By.xpath("//span[.='Jackets']"));
		Actions a=new Actions(d);
		a.moveToElement(x).build().perform();
		
	}
	

}
