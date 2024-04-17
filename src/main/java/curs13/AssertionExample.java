package curs13;

import static org.testng.Assert.assertEquals;

import org.testng.TestException;
import org.testng.annotations.Test;

public class AssertionExample {

	String expectedTitle = "Test";
	String actualTitle = "Test2";
	
	@Test
	public void checkEquality() {
		
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Test is passed");
		}else {
			System.out.println("Test is failed");
			throw new TestException("Test is failed");
		}	
	}
	
	@Test
	public void checkEqualityWithAssert() {
		
		assertEquals(expectedTitle, actualTitle);
		
	}
	
}
