package curs14;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import seleniumUtils.BaseTest;

public class SeleniumLocatorsExample extends BaseTest {
	
	/*
	* driver.findElement(By.className("logo")).click();
	* |			webelement					  | actiune pe webelement
	* 
	* WebElement logo = driver.findElement(By.className("logo"))
	* logo.click();
	* logo.getText();
	* 
	* Selenium locators:
	* ---> by tagName
	* ---> by linkText
	* ---> by partialLinkText
	* ---> by id
	* ---> by className
	* ---> by name
	* ---> by cssSelector
	* ---> by xpath
	* 
	* Selenium relative locators
	* ---> above
	* ---> bellow
	* ---> near
	* ---> toLeftOf
	* ---> toRightOf
	* 
	* 
	*/
	
	@Test(priority =1)
	public void tagNameLocator() {
		// <em>Discover</em>
		// driver.findElement(By.tagName("em")).click();
		WebElement discoverText = driver.findElement(By.tagName("em"));
		String text = discoverText.getText(); //metoda getText() -> intoarce textul dintre tagurile html;
		System.out.println(text);
		assertEquals(text,"Discover");
	}
	
	@Test(priority = 2)
	public void linkTextLocator() {
		// <a href="link">Books</a>
		WebElement booksLink = driver.findElement(By.linkText("BOOKS"));
		booksLink.click();
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		assertEquals(currentUrl, "https://keybooks.ro/shop/");
		}
	
	
	@Test(priority = 3)
	public void partialLinkText() {
		// <a href="link">Cooking with love</a>
		WebElement cookingBook = driver.findElement(By.partialLinkText("Cooking"));
		cookingBook.click();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/cooking-with-love");
		}
		
	
	@Test(priority = 4)
	public void classNameLocator() {
		WebElement price = driver.findElement(By.className("price"));
		System.out.println(price.getText());
		assertTrue(price.getText().contains("18.49"));
		}
}
