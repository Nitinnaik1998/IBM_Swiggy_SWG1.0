package com.swiggy.FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String sheetName, int rownum, int cellnum) throws Exception {
		FileInputStream fis = new FileInputStream(".\\testdata\\NitintestscriptdataExcel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
		return data;

	}
	public String getDataFromExcelforSpotify(String sheetName, int rownum, int cellnum) throws Exception {
		FileInputStream fis = new FileInputStream(".\\testdata\\Nitin.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
		return data;
		
	}

	public int getRowcount(String sheetName) throws Exception {
		FileInputStream fis = new FileInputStream(".\\testdata\\testscriptdataExcel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		return rowCount;
	}

	public void setDataIntoExcel(String sheetName, int rownum, int cellnum,String data) throws Exception {
		FileInputStream fis = new FileInputStream(".\\testdata\\Nitin.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		Sheet sh=wb.getSheet(sheetName);
		
		Row row=sh.getRow(rownum);
		
		if(row==null) {
			row=sh.createRow(rownum);
		}
	    
		Cell cell=row.createCell(cellnum);
		cell.setCellValue(data);

		FileOutputStream fos = new FileOutputStream(".\\testdata\\Nitin.xlsx");
		wb.write(fos);
		wb.close();
	}
	
	public void setDataIntoExcelByCreatingSheet(String sheetName, int rownum, int cellnum,String data) throws Exception {
		FileInputStream fis = new FileInputStream(".\\testdata\\Nitin.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		if(sh==null) {
		sh=wb.createSheet(sheetName);
		}
		Row row=sh.getRow(rownum);
		
		if(row==null) {
			row=sh.createRow(rownum);
		}
        Cell cell=row.getCell(cellnum);
		
		if(cell==null) {
			cell=row.createCell(cellnum);
		}
		
		cell.setCellValue(data);

		FileOutputStream fos = new FileOutputStream(".\\testdata\\Nitin.xlsx");
		wb.write(fos);
		wb.close();
		
	}


public String getDataFromExcelforShoppersStack(String sheetName, int rownum, int cellnum) throws Exception {
	FileInputStream fis = new FileInputStream(".\\testdata\\ReadMultipleData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String data = wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
	return data;
	
}
}

