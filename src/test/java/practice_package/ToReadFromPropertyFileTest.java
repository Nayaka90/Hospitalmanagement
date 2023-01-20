package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class ToReadFromPropertyFileTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.property");
		Properties p = new Properties();
		p.load(fis);
		System.out.println(p.getProperty("url"));
		

	}
}
