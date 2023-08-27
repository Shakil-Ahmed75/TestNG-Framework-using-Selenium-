package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TC_02_IteratorMethod {

	public static void main(String[] args) throws IOException {

		String excelPath = "C:\\Users\\ShakilAhmed\\git\\TestNG-Framework-using-Selenium-\\TestNGFramework\\dataFiles\\ApachePOI.xlsx";
		FileInputStream inputStream = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator iterator = sheet.iterator();
		while (iterator.hasNext()) {
			
			XSSFRow row = (XSSFRow) iterator.next();
			Iterator cellIterator = row.cellIterator();
			
			while (cellIterator.hasNext()) {
             XSSFCell cell = (XSSFCell) cellIterator.next();
             switch (cell.getCellType()) {
				
				case STRING:System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:System.out.print(cell.getNumericCellValue());
				    break;
				case BOOLEAN:System.out.print(cell.getBooleanCellValue());
					break;
				}
				System.out.print("|");
				}	
			    System.out.println();
			}
	           
             
			}
		

	}


