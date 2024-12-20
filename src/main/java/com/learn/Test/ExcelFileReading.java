package com.learn.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelFileReading {

	static void getSheetData(Workbook workbook, int sheetNo, String filterBy) {

		Sheet sheet = workbook.getSheetAt(sheetNo);

		System.out.println("Last Row :" + sheet.getLastRowNum());
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {

			System.out.println("Reading Row " + i);
			Row row = sheet.getRow(i);
			
			if(row.getCell(2).getStringCellValue().contains(filterBy)) {
				
			}

			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);

				if (cell.getCellType() == CellType.STRING) {
					System.out.println(cell.getStringCellValue());
				}
				if (cell.getCellType() == CellType.BOOLEAN) {
					System.out.println(cell.getBooleanCellValue());
				}
				if (cell.getCellType() == CellType.NUMERIC) {
					System.out.println(cell.getNumericCellValue());
				}

				// System.out.println(cell.getClass() + "\t"+new
				// DataFormatter().formatCellValue(cell));

			}

			System.out.println("*************************");

		}
		

	}

	public static void main(String[] args) {
		
		
		 try {
			 
			Workbook workbook = new HSSFWorkbook(new FileInputStream(new File("Book1.xls")));
			
			getSheetData(workbook,0,"addUser");
			System.out.println("************|||||||||||||||||||||||||||*************");
			getSheetData(workbook,1,"getUser");
			
		 }
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 
	}
	}

