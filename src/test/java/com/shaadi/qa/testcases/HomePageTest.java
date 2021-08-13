package com.shaadi.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shaadi.qa.base.TestBase;
import com.shaadi.qa.pages.HomePage;

public class HomePageTest extends TestBase{
	HomePage homepage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePage();
	}

	@Test
	public void SetUpAccounttest() {
		homepage.SetUpAccount();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
