package dataDrivenTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_01_DataDrivenTesting {

	public static void main(String[] args) {

		XSSFWorkbook ExcelWBook = null;
		XSSFSheet ExcelWSheet;
//		XSSFRow Row;
//		XSSFCell Cell;

		File excelFile = new File("C:\\Users\\ShakilAhmed\\Desktop\\Test\\TestData.xlsx");
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(excelFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// excel->workbook->sheet->row-> cell
		try {
			ExcelWBook = new XSSFWorkbook(inputStream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// to access workbook sheet
		ExcelWSheet = ExcelWBook.getSheetAt(0);

		// get row number
		int ttlRows = ExcelWSheet.getLastRowNum() + 1;
		int ttlCells = ExcelWSheet.getRow(0).getLastCellNum();

		for (int currentRow = 1; currentRow < ttlRows; currentRow++) {

			//for (int currentCell = 0; currentCell < ttlCells; currentCell++) {

            //Launch Chrome Browser
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.get("https://www.saucedemo.com/");
//				driver.quit();
				
				//enter username
				driver.findElement(By.id("user-name")).sendKeys(ExcelWSheet.getRow(currentRow).getCell(0).toString());
				//password
				driver.findElement(By.id("password")).sendKeys(ExcelWSheet.getRow(currentRow).getCell(1).toString());
				driver.findElement(By.id("login-button")).click();
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				driver.quit();
				
//				System.out.println(ExcelWSheet.getRow(currentRow).getCell(currentCell).toString());
//
//				System.out.print("\t");
			}
			
		}
		

		
	}


