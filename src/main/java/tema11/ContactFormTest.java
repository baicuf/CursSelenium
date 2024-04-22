package tema11;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import seleniumUtils.BaseTest;

public class ContactFormTest extends BaseTest{
	
	String contactURL = "https://keybooks.ro/contacts/";
	
	@Test(priority = 1)
	public void accessContactForm() {
		
		// Access contact form and verify navigation.
		driver.findElement(By.cssSelector(".menu-item-72")).click();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/contacts/");
		}
	
	@Test(priority = 2)
	public void fillInContactForm() throws InterruptedException {
		
		// Scroll to form.
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 500).perform();
		
		// Fill in name.
		driver.findElement(By.cssSelector("p>span[class~='your-name']>input[name='your-name']")).sendKeys("Tester Automaticus");
		
		// Fill in email.
		driver.findElement(By.cssSelector("input[name*='email']")).sendKeys("automaticus@machina.net");
		
		// Fill in subject.
		driver.findElement(By.cssSelector("p input[name$='-s']")).sendKeys("I loved this book!");
		
		// Fill in message.
		String message = "I loved this book but could you please rewrite it an change the ending?\n "
				+ "We all know the butler was the actual killer, everyone knows that.\n\n\n"
				+ "THE BUTLER DID IT!!!!";
		driver.findElement(By.cssSelector("p>span[class='wpcf7-form-control-wrap your-message']>textarea[name='your-message']")).sendKeys(message);
		
		// Just to confirm form is filled in correctly - can be removed.
		Thread.sleep(5000);
		
		// Submit the contact form.
		driver.findElement(By.cssSelector("input[value^='Send'][value$='Message']")).click();
		
		// Check if success message is visible.
		boolean successMessage = driver.findElement(By.cssSelector("div[class='wpcf7-response-output']")).isDisplayed();
		assertTrue(successMessage);
		
		// Check if the success message is correct.
		String message1 = driver.findElement(By.cssSelector("div[class='wpcf7-response-output']")).getText();
		assertEquals(message1, "Thank you for your message. It has been sent.");
		}

}
