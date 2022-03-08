package com.appium.Utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excel_Data_Provider {
	
	XSSFWorkbook wb;

	public Excel_Data_Provider()
	{
	File src=new File("./TestData/Data.xlsx");
	try {
		FileInputStream fis = new FileInputStream(src);
		wb=new XSSFWorkbook(fis);
	} catch (Exception e) {
		
		System.out.println("Unable to read excel file "+e.getMessage());
	}
	
}

	public String getStringData(String SheetName, int row, int column)
		{
			return wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
		}

	public double getNumericData(String SheetName, int row, int column)
		{
			return wb.getSheet(SheetName).getRow(row).getCell(column).getNumericCellValue();
	
	
		}	
	
	
}
