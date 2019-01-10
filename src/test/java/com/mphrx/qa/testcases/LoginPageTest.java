package com.mphrx.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mphrx.qa.base.TestBase;
import com.mphrx.qa.pages.HomePage;
import com.mphrx.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage=new LoginPage();
		
	}
	@Test(priority=1)
	public void loginPageTitileTest()
	{
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "title");
 	}
	
	@Test(priority=2)
	public void logoImageTest()
	{
		boolean flag= loginPage.validateLogo();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
	
	public void loginTest()
	{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown()
	
	{
		driver.quit();
	}
	
}
