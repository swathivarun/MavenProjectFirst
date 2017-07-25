package testScenarios;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commonLib.BaseTest;
import commonLib.ExcelLib;
import utiltiy.ConstantsVariable;
import webPages.HomePage;
import webPages.LoginPage;

public class DataDrivenTest 
{
	public WebDriver driver;
	SoftAssert soft;
	ExcelLib lib;
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

	@Test(description="validating login with Invalid credentials ", enabled=true)
	public void test2()
	{
		String res=null;
		LoginPage loginpage = new LoginPage(driver);	
		lib = new ExcelLib();
		int rc= lib.getrowcount(ConstantsVariable.filepath, ConstantsVariable.sheetname);
		for(int i=1;i<=rc;i++)
		{
			String username=lib.readexceldata(ConstantsVariable.filepath, ConstantsVariable.sheetname, i, 0);
			String password=lib.readexceldata(ConstantsVariable.filepath, ConstantsVariable.sheetname, i, 1);
			try
			{
				res=loginpage.inValidLogin(username,password );
				lib.writeexceldata(ConstantsVariable.filepath, ConstantsVariable.sheetname, i, 2,res);
				Assert.assertTrue(res.contains("Please try again."),"error on the page");
			} catch (Exception e) {
				HomePage homepage = new HomePage(driver);
				homepage.timeTrackTab();
				homepage.logout();
				lib.writeexceldata(ConstantsVariable.filepath, ConstantsVariable.sheetname, i, 2,"logged in ");
			}
			
		}

	}

}
