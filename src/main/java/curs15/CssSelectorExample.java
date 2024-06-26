package curs15;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import seleniumUtils.BaseTest;

public class CssSelectorExample extends BaseTest{
	
//	@Test
	public void cssExample1() {
		
		// <h2 class="sc_title sc_title_underline sc_align_center margin_bottom_tiny" style="margin-t
		// .sc_title_underline
		// h2[class='sc_title sc_title_underline sc_align_center margin_bottom_tiny']
		
		// CssSelector pentru atribut class --> .
		// .menu_main_nav_area
		// nav[class='menu_main_nav_area']
		
		// CssSelector pentru atribut id --> #
		// #menu_user --> gaseste orice element care are id (#) cu valoarea 'menu_user'
		// ul#menu_user --> gaseste doar elementele care au tagname'ul' si id (#) 'menu_user'
		// ul[id='menu_user'] --> gaseste doar elementele care au tagname'ul' si id (#) 'menu_user'
		// ul --> tagname
		// id (#) --> atribut
		// menu_user --> valoarea atributului
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		WebElement loginMenu = driver.findElement(By.cssSelector("#menu_user"));
		jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid red;')", loginMenu);
		
		WebElement logoSlogan = driver.findElement(By.cssSelector("div[class='logo_slogan']"));
		jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid red;')", logoSlogan);
	}
	
//	@Test
	public void cssExample2() {
		
		//a[href='#popup_login']
		WebElement loginPopup = driver.findElement(By.cssSelector("a[href='#popup_login']"));
		loginPopup.click();
		
		//input#log
		//input[id='log']
		
		//logical AND
		//input[id='log'][name='log'][placeholder='Login or Email']
		WebElement usernameField = driver.findElement(By.cssSelector("input[id='log']"));
		usernameField.sendKeys("Test User");
		
		//logical OR
		//input[id='password']
		//input[id='password'],[name='pwd']
		WebElement passwordField = driver.findElement(By.cssSelector("input[id='password'],[name='pwd']"));
		passwordField.sendKeys("password");
	}

//	@Test
	public void cssExample3() {
		
		// a[href='the-long-road-to-the-deep-silence']
		
		// ** Wildcards **
		
		// * --> contains
		// a[href*='road-to-the-deep']
		
		WebElement book1 = driver.findElement(By.cssSelector("a[href*='road-to-the-deep']"));
		System.out.println(book1.getText());
		
		// h3[class~='sc_title_regular']
		// ~ --> contains word, cauta o succesiune de caractere intre doua spatii
		
		WebElement book2 = driver.findElement(By.cssSelector("h3[class~='sc_title_regular']"));
		System.out.println(book2.getText());
		
		// a[href^='life']
		// ^ --> starts with
		
		WebElement book3 = driver.findElement(By.cssSelector("a[href^='life']"));
		System.out.println(book3.getText());
		
		// a[href$='story']
		// $ --> ends with
		
		WebElement book4 = driver.findElement(By.cssSelector("a[href$='story']"));
		System.out.println(book4.getText());
		
	}
	
	@Test
	public void cssExample4() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		// Navigarea in interiorul unui tagname (doar in jos)
		//ul[role='tablist']>li --> ">" direct child
		//ul[role='tablist'] a --> " " oricare element din interior chiar daca nu este direct child
		//ul>li[role='tab']
		
		List<WebElement> menuEntries = driver.findElements(By.cssSelector("ul[role='tablist']>li"));
		jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid green;')", menuEntries.get(3));
		
		//ul[role='tablist']>li[aria-selected='true']
		WebElement selectedMenuEntry = driver.findElement(By.cssSelector("ul[role='tablist']>li[aria-selected='true']"));
		jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid blue;')", selectedMenuEntry);
		
		//ul[role='tablist']>li:not[aria-selected='true'] -> not - selecteaza elementele care nu indeplinesc regula
		List<WebElement> notSelectedMenuEntries = driver.findElements(By.cssSelector("ul[role='tablist']>li:not[aria-selected='true']"));
		for (WebElement element : notSelectedMenuEntries) {
			
			jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid orange;')", element);
		}
		
		
		// ul[role='tablist']>li[role='tab']>a[href*='#sc_tab']
		// ul parinte al lui li
			// li este copil al lui ul si parinte al lui a
				//a este copil al lui li si nepot al lui ul
		
		List<WebElement> menuLinks = driver.findElements(By.cssSelector(" ul[role='tablist'] a[href*='#sc_tab']"));
		for (WebElement element : menuLinks) {
			
			jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid pink;')", element);
		}
	}
	
}
