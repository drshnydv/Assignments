package org.genriclib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public Workbook getWorkbook() throws Throwable {
		FileInputStream fis = new FileInputStream(IConstants.excelPath);
		return WorkbookFactory.create(fis);
	}

	public Row createRow(Workbook wb, String sheet, int row) {
		Sheet sh = wb.getSheet(sheet);
		return sh.createRow(row);
	}

	public void createCellAndSetCellValue(Row ro, int cell, String data) {
		Cell ce = ro.createCell(cell);
		ce.setCellValue(data);
	}

	public void writeDataToExcel(Workbook wb) throws Throwable {
		FileOutputStream fos = new FileOutputStream(IConstants.excelPath);
		wb.write(fos);
		wb.close();
	}

	public Row getRow(Workbook wb, String sheet, int row) {
		Sheet sh = wb.getSheet(sheet);
		return sh.getRow(row);
	}

	public String getCell(Row ro, int cell) {
		return ro.getCell(cell).toString();
	}
	
	public int getRowCount(Workbook wb,String sheet) {	
		return wb.getSheet(sheet).getLastRowNum();	
	}
	
	public int getCellCount(Workbook wb, String sheet, int row) {
		return wb.getSheet(sheet).getRow(row).getLastCellNum();
	}
	
	public String getExcelData(String sheet, int row, int cell) throws Throwable {
		FileInputStream fis = new FileInputStream(IConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheet).getRow(row).getCell(cell).toString();
	}

}