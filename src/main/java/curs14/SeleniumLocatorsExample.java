package curs14;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/cooking-with-love/");
		}
		
	
	@Test(priority = 4)
	public void classNameLocator() {
		WebElement price = driver.findElement(By.className("price"));
		System.out.println(price.getText());
		assertTrue(price.getText().contains("18.49"));
		}
	
	@Test(priority = 5)
	public void idLocator() {
		
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 500).perform();
		
		WebElement reviewTab = driver.findElement(By.id("tab-title-reviews"));
		reviewTab.click();

		}
	
	@Test(priority = 6)
	public void nameLocator() {
		
		WebElement commentBox = driver.findElement(By.name("comment"));
		commentBox.sendKeys("My super duper message!");

		}
	
	@Test(priority = 7)
	public void cssLocator() throws InterruptedException {
		
		WebElement nameBox = driver.findElement(By.cssSelector("input[name='author']"));
		nameBox.sendKeys("Johnny Bravo");
		Thread.sleep(3000);
		nameBox.clear();
		Thread.sleep(3000);
		nameBox.sendKeys("John Doe");
		Thread.sleep(3000);

		}
	
	@Test(priority = 8)
	public void xpath() throws InterruptedException {
		
		WebElement emailBox = driver.findElement(By.xpath("//input[@type='email']"));
		emailBox.sendKeys("johnny.bravo@domain.com");

		}
}
