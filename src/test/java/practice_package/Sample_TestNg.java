package practice_package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hms.generic.ExcelUtility;

public class Sample_TestNg {
	@Test
	public void Created() {
		System.out.println("Created");
	}

	@Test
	public void updated() {
		System.out.println("Updated");
	}

	@Test(dataProvider ="data" )
	public void deleted(String a,String b) {
		System.out.println(a+"---->"+b);
	}

	@DataProvider
	public Object[][] data() throws Throwable{
		Object[][] obj = new Object[2][2];
		obj[0][0]="Nithish";
		obj[0][1]="Sathish";

		obj[1][0]="Pothish";
		obj[1][1]="vathish";

		
		ExcelUtility e=new ExcelUtility();
	obj=	e.toReadMultipleData("DataProvider");
		
		
		return obj;
	}
}
