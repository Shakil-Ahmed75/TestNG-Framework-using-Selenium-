package basicselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import webDriverSets.BaseDriver;

public class MouseActionsClick extends BaseDriver {
	String url="https://www.amazon.com/";
	
	@Test
	public void actionDemo () {
		driver.get(url);
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList-nav-line-1"))).build().perform();
		
		
	}

}
