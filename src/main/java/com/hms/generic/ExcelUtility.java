 package com.hms.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Parameters;

public class ExcelUtility {
	private FileInputStream fis;

	/**
	 * This method is used to get Data from Excelfile.
	 * 
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return String data
	 * @throws Throwable
	 */

	public String getDataFromExcel(String Browsers,String sheetname, int rownum, int cellnum) throws Throwable {
		Object FileInputStream;
		if(Browsers.equalsIgnoreCase("chrome"))
		fis = new FileInputStream(IpathConstraints.Excel_Path);
		else if(Browsers.equalsIgnoreCase("microsoftedge")) 
	     fis = new FileInputStream(IpathConstraints.Excel_Path1);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		String data = sh.getRow(rownum).getCell(cellnum).getStringCellValue();
		return data;
	}

	/**
	 * This method is used to write Data to Excelfile.
	 * 
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @param data
	 * @throws Throwable
	 */

	public void setDataToExcel(String Browsers,String sheetname, int rownum, int cellnum, String data) throws Throwable {
		Object FileInputStream;
		if(Browsers.equalsIgnoreCase("chrome"))
		fis = new FileInputStream(IpathConstraints.Excel_Path);
		else if(Browsers.equalsIgnoreCase("microsoftedge")) 
	     fis = new FileInputStream(IpathConstraints.Excel_Path1);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		sh.getRow(rownum).createCell(cellnum).setCellValue(data);
		FileOutputStream fos = null;
		if(Browsers.equalsIgnoreCase("chrome"))
			fos = new FileOutputStream(IpathConstraints.Excel_Path);
			else if(Browsers.equalsIgnoreCase("microsoftedge")) 
		     fos = new FileOutputStream(IpathConstraints.Excel_Path1);
		wb.write(fos);
	}

	/**
	 * This method is used to get Last row number from Sheet of Excelfile.
	 * 
	 * @param sheetname
	 * @return int last row number
	 * @throws Throwable
	 */
	public int getLastRow(String sheetname) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstraints.Excel_Path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		return sh.getLastRowNum();
	}
	
	/**
	 * This method is Used To Read and store Multiple Data from excel into Object[][] and return it
	 * * @param sheetname
	 * @return Object[][]
	 * @throws Throwable
	 */
	public Object[][] toReadMultipleData(String sheetname) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstraints.Excel_Path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int rowcount=sh.getLastRowNum()+1;
		int cellcount=sh.getRow(0).getLastCellNum();
		Object[][] Obj = new Object[rowcount][cellcount];
		for (int i = 0; i <rowcount; i++) {
			for (int j = 0; j<cellcount; j++) {
				
				Obj [i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return Obj;
	}
   
}
