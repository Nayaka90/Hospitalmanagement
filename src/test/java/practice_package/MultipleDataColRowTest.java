package practice_package;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MultipleDataColRowTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet("-createpromote").getLastRowNum();
		int cellcount = wb.getSheet("-createpromote").getRow(0).getLastCellNum();
		for (int i = 1; i <= rowcount; i++) {
			for (int j = 0; j < cellcount; j++) {
				String data = wb.getSheet("-createpromote").getRow(i).getCell(j).getStringCellValue();
				System.out.println(data);
			}
		}
	}
}