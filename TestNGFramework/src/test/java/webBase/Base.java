package webBase;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	 WebDriver driver;

	@BeforeMethod
	public void setUp() {
//		WebDriverManager.firefoxdriver().setup();
//		driver =new FirefoxDriver();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// setup url
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}


	@Test(dataProvider="SearchDataProvider" )
    public void searchKeyWord( String keyWord ) {
    	//name="q"
    	
		WebElement searchBox = driver.findElement(By.id("APjFqb"));
    	searchBox.sendKeys(keyWord);
    	searchBox.sendKeys(Keys.ENTER);
	} 
	@DataProvider(name="SearchDataProvider")
	public Object[][] searchDataProviderMethod() {
		
			String fileName="C:\\Users\\ShakilAhmed\\Desktop\\Test\\DataProvider With Excel.xlsx";
			Object[][] searchData=getExcelData(fileName,"Sheet1");
			
			return searchData;
//			Object[][] searchData = new Object[2][1];
//			searchData[0][0] = "Dhaka";
//			searchData[1][0] = "RajShahi";
			

		}
	

	 public String[][] getExcelData(String fileName, String sheetName) {
		String[][] data=null;
		try {
			FileInputStream inputStream = new FileInputStream(fileName);
			XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
			XSSFSheet excelSheet = workBook.getSheet(sheetName);
             // get total no . of rows
			int ttlRows = excelSheet.getLastRowNum();
			// get total no . of cell
			int ttlCells = excelSheet.getRow(0).getLastCellNum();
			data= new String[ttlRows-1][ttlCells];
			
			for (int currentRow = 0; currentRow < ttlRows; currentRow++) {
			for (int currentCell = 0; currentCell < ttlCells; currentCell++) {
            data[currentRow-1][currentCell] = excelSheet.getRow(currentRow).getCell(currentCell).getStringCellValue();
					// toString();
				}
			}
			workBook.close();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return data;

	}

	@AfterMethod
	public void close() {
		driver.close();

	}

}
