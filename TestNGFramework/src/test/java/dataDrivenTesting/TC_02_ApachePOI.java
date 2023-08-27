package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TC_02_ApachePOI {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//XSSFWorkbook->Workbook
		//XSSFSheet -> Sheet
		//XSSFRow -> Row
		//XSSFCell-> Cell 
		String excelPath ="C:\\Users\\ShakilAhmed\\git\\TestNG-Framework-using-Selenium-\\TestNGFramework\\dataFiles\\ApachePOI.xlsx";
		try {
			FileInputStream inputStream =new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheetAt(0);
			//using for loop
			int ttlRows = sheet.getLastRowNum();
			int ttlCols =sheet.getRow(1).getLastCellNum();
			for(int row=0; row<ttlRows; row++) {
				XSSFRow rw=sheet.getRow(row);
				for(int cols=0; cols<ttlCols; cols++) {
				XSSFCell cl=rw.getCell(cols);
				switch (cl.getCellType()) {
				
				case STRING:System.out.print(cl.getStringCellValue());
					break;
				case NUMERIC:System.out.print(cl.getNumericCellValue());
				    break;
				case BOOLEAN:System.out.print(cl.getBooleanCellValue());
					break;
				}
				System.out.print(" | ");
				}
				System.out.println();
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
