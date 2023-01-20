package practice_package;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleInputFromExcelTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet("-createpromote").getLastRowNum();
		for (int i = 1; i <= rowcount; i++) {
			String data = wb.getSheet("-createpromote").getRow(i).getCell(0).getStringCellValue();
			System.out.println(data);
		}
	}
}
