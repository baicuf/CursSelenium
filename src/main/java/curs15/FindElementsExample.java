package curs15;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import seleniumUtils.BaseTest;

public class FindElementsExample extends BaseTest{
	
	@Test
	public void findElementsTest() {
		
		
		// figure[class*='sc_image_shape_square']
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		List<WebElement> bookImages = driver.findElements(By.cssSelector("figure[class*='sc_image_shape_square']"));
		jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid red;')", bookImages.get(1));
	}

}
