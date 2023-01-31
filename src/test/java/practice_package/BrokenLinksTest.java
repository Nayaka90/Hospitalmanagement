package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksTest {

	public static void main(String arg[])  throws Throwable {
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		List<WebElement> all = driver.findElements(By.xpath("//a"));

		FileInputStream fis=new FileInputStream("C:\\Users\\navee\\OneDrive\\Desktop\\Brokenlinks.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet("new3");
		for (int i = 0; i <all.size(); i++) {

			String links = all.get(i).getAttribute("href");
			sh.createRow(i).createCell(0).setCellValue(links);
			URL url = new URL(links);	 
			URLConnection urlconn = url.openConnection();
			String responsecode = ""+( (HttpURLConnection)urlconn).getResponseCode();
			sh.getRow(i).createCell(1).setCellValue(responsecode);
			FileOutputStream fos=new FileOutputStream("C:\\Users\\navee\\OneDrive\\Desktop\\Brokenlinks.xlsx");
			wb.write(fos);
			
		}
	}

}
