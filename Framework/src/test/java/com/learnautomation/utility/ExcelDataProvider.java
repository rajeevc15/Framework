package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb; 
	public ExcelDataProvider() {
		try {
		File src=new File("./TestData/TestData.xlsx");
		
			FileInputStream fis=new FileInputStream(src);
			 wb=new XSSFWorkbook(fis);
			
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
		} 
		
	}
	
	//The below 2 methods are examples of method overloading, same method name, same no.of parameters, ,but data type changed between the methods
	public String getStringData(int sheetindex, int row, int column) {
		String stringdata = wb.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();
		return stringdata;
	}
	
	public String getStringData(String sheet, int row, int column) {
		String stringdata = wb.getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
		return stringdata;
	}

	public double getintData(String sheet, int row, int column) {
		Double intdata = wb.getSheet(sheet).getRow(row).getCell(column).getNumericCellValue();
		return intdata;
	}
}
