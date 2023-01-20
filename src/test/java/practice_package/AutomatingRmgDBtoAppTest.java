package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

public class AutomatingRmgDBtoAppTest {
	public static void main(String[] args) throws SQLException {
		//to insert data into database
		Connection con = null;
		int res = 0;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			Statement stat = con.createStatement();
			String query = "insert into project values('TY_Project_156','Nithish','21/1/2022','sdet_45_Nayak','creted',0);";
			res = stat.executeUpdate(query);
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (res == 1)
				System.out.println("updated successfully");
			else
				System.out.println("notupdated");

			con.close();
		}

		//to check created project visible in frontend or not.
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).submit();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		WebElement data = driver.findElement(By.xpath("//td[.='TY_Project_156']"));

		if (data.isDisplayed())
			System.out.println("project is visible");

		else
			System.out.println("project not there");
		driver.close();

	}

}
