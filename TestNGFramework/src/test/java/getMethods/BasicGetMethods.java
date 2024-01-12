package getMethods;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicGetMethods {

	WebDriver driver;

	@Test
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.globalsqa.com/");
		driver.manage().window().maximize();

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		String text = driver.findElement(By.xpath("//div[@class='header_mail']")).getText();
		System.out.println(text);

	}

}
