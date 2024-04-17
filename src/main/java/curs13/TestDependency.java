package curs13;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestDependency {

	@Test(priority = 1)
	public void test1() {
		assertTrue(false);
		System.out.println("Test case 1");
	}
	@Test(priority = 2, dependsOnMethods = "test1")
	public void test2() {
		System.out.println("Test case 2");
	}
	@Test(priority = 3, dependsOnMethods = "test2", alwaysRun = true)
	public void test3() {
		System.out.println("Test case 3");
	}
	
	
}
