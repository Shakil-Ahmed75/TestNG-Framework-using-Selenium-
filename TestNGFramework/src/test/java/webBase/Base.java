package webBase;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
   public static WebDriver driver;
  @BeforeMethod	 
   public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//setup url 
		driver.get("https://www.google.com/");
	   driver.manage().window().maximize();	
	}
    
  @Test(dataProvider="SearchDataProvider" )
    public void searchKeyWord( String keyWord ) {
    	//name="q"
    	WebElement searchBox = driver.findElement(By.name("q"));
    	searchBox.sendKeys(keyWord);
    	searchBox.sendKeys(Keys.ENTER);
	} 
    
    @DataProvider(name= "SearchDataProvider")
      public Object[][] searchDataProviderMethod() {
    	  {
    	    	Object[][] searchData = new Object[2][1];
   	    	searchData[0][0]="Dhaka";
  	    	searchData[1][0]="RajShahi";
  	    	return searchData;
   	    	
   	    }
		
	}
  
  @AfterMethod
  public void close() {
  driver.close();
	
}
  
}
