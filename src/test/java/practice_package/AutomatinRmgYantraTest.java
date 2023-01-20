package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class AutomatinRmgYantraTest {
	static {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
	}

	public static void main(String[] args) throws SQLException {

		// to create project in Frontend
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver:8084/");

		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).submit();
		driver.findElement(By.xpath("//a[.='Projects']")).click();

		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys("SDET_49_N");
		driver.findElement(By.name("createdBy")).sendKeys("Arjun");
		WebElement e = driver.findElement(By.name("status"));
		Select s = new Select(e);
		s.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).submit();

		driver.close();

		// to check whether data has been stored in database or not.
		Connection con = null;
		try {
			Driver driver1 = new Driver();
			DriverManager.registerDriver(driver1);
			con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			Statement stat = con.createStatement();
			String query = "select * from project;";
			ResultSet res = stat.executeQuery(query);
			boolean flag = false;
			while (res.next()) {
				String Projectname = res.getString(4);
				if (Projectname.equalsIgnoreCase("SDET_49_N")) {
					System.out.println("project is created");
					flag = true;
					break;
				}
			}
			if (flag == false)
				System.out.println("project is not created");
		} catch (Exception n) {

		} finally {
			con.close();
		}
	}
}
