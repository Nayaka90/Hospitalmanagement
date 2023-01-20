package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UpadteDatatoExcelTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet("+createpromote").getRow(1).getCell(0).setCellValue("HPlaptop1");
		wb.getSheet("+createpromote").createRow(1).createCell(0).setCellValue("HPlaptop9");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/testscript.xlsx");
		wb.write(fos);
		wb.close();
	}
}
