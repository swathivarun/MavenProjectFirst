package testScenarios;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commonLib.BaseTest;
import utiltiy.ConstantsVariable;
import webPages.LoginPage;

public class LoginTestScearios 
{
	public WebDriver driver;
	SoftAssert soft;
	@BeforeMethod
	public void setUp()
	{
		BaseTest basetest = new BaseTest();
		driver=basetest.selectBrowser(ConstantsVariable.browsername);
		driver.get(ConstantsVariable.baseurl);
		driver.manage().window().maximize();
		soft = new SoftAssert();
	}
	
	@AfterMethod
	public void teadDown()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	@Test(description="validating login with valid credentials ")
	public void test1()
	{
		LoginPage loginpage = new LoginPage(driver);	
		String res=loginpage.validLogin(ConstantsVariable.username, ConstantsVariable.password, ConstantsVariable.title);
		Assert.assertEquals(driver.getTitle(), res,"fail to login");
	}
	
	@Test(description="validating login with Invalid credentials ", enabled=true)
	public void test2()
	{
		LoginPage loginpage = new LoginPage(driver);	
		String res=loginpage.inValidLogin(ConstantsVariable.usernameWrong, ConstantsVariable.passwordWrong);
		Assert.assertTrue(res.contains("Please try again."),"error on the page");
	}
	
	@Test(description="validating place holder")
	public void test3()
	{
		LoginPage loginpage = new LoginPage(driver);
		String res=loginpage.verifyPlaceholderUsername();
		soft.assertTrue(res.contains("Username"),"username palce holder txt is incorect");
		String res1=loginpage.verifyPlaceholderPassword();
		soft.assertTrue(res1.contains("Password"),"password palce holder txt is incorect");
		soft.assertAll();
	}
}
