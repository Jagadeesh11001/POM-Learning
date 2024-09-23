package utils;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTest extends Report {

	@BeforeTest
	void setData() {
		desc = "first test";
		author = "Jagan";
		category = "reg";
	}
	
	@Test
	void myTest() {
		System.out.println("Test Begins");
		stepReport("pass", "some descriotion");
		System.out.println("Test ends");
	}
}
