package tema10;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import seleniumUtils.BaseTest;

public class LoginValidation extends BaseTest{
	

	// Check if Login button exists
	@Test(priority = 1)
	public void loginButton() {
		WebElement loginButton = driver.findElement(By.className("menu_user_login"));
		assertEquals(loginButton.getText(), "Login");
		}
	
	// Check if Login fields Email/Password are not visible
	@Test(priority = 2)
	public void loginElements() {
		boolean emailIsVisible = driver.findElement(By.name("log")).isDisplayed();
		assertTrue(!emailIsVisible);
		boolean passwordIsVisible = driver.findElement(By.name("pwd")).isDisplayed();
		assertTrue(!passwordIsVisible);
		}
	
	// Check if Login fields Email/Password are not visible
	@Test(priority = 3)
	public void clickLogin() {
		driver.findElement(By.className("menu_user_login")).click();
		boolean emailIsVisible = driver.findElement(By.name("log")).isDisplayed();
		assertTrue(emailIsVisible);
		boolean passwordIsVisible = driver.findElement(By.name("pwd")).isDisplayed();
		assertTrue(passwordIsVisible);
		}
}
