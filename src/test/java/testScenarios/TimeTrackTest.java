package testScenarios;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commonLib.BaseTest;
import utiltiy.ConstantsVariable;
import webPages.HomePage;
import webPages.LoginPage;
import webPages.TimeTrack;

public class TimeTrackTest 
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
	
	@Test(description="create new task")
	public void test1()
	{
		LoginPage loginpage = new LoginPage(driver);	
		String res=loginpage.validLogin(ConstantsVariable.username, ConstantsVariable.password, ConstantsVariable.title);
		Assert.assertEquals(driver.getTitle(), res,"fail to login");
		HomePage homepage = new HomePage(driver);
		homepage.timeTrackTab();
		TimeTrack timetrack = new TimeTrack(driver);
		timetrack.selectItemFromDropdown(ConstantsVariable.taskusername);
		timetrack.calender(ConstantsVariable.expMonth, ConstantsVariable.expdate);
		timetrack.selectTask(ConstantsVariable.taskname1, ConstantsVariable.hr);
		String res1=timetrack.submitbtn();
		Assert.assertTrue(res1.contains("successfully"),"fail to create task");	
		
	}
	
	@Test(description="create new task")
	public void test2()
	{
		LoginPage loginpage = new LoginPage(driver);	
		String res=loginpage.validLogin(ConstantsVariable.username, ConstantsVariable.password, ConstantsVariable.title);
		Assert.assertEquals(driver.getTitle(), res,"fail to login");
		HomePage homepage = new HomePage(driver);
		homepage.timeTrackTab();
		TimeTrack timetrack = new TimeTrack(driver);
		timetrack.selectItemFromDropdown(ConstantsVariable.taskusername);
		timetrack.calender(ConstantsVariable.expMonth, ConstantsVariable.expdate);
		timetrack.selectTask(ConstantsVariable.taskname2, ConstantsVariable.hr);
		String res1=timetrack.submitbtn();
		Assert.assertTrue(res1.contains("successfully"),"fail to create task");	
		
	}
	
	@Test(description="create new task")
	public void test3()
	{
		LoginPage loginpage = new LoginPage(driver);	
		String res=loginpage.validLogin(ConstantsVariable.username, ConstantsVariable.password, ConstantsVariable.title);
		Assert.assertEquals(driver.getTitle(), res,"fail to login");
		HomePage homepage = new HomePage(driver);
		homepage.timeTrackTab();
		TimeTrack timetrack = new TimeTrack(driver);
		timetrack.selectItemFromDropdown(ConstantsVariable.taskusername);
		timetrack.calender(ConstantsVariable.expMonth, ConstantsVariable.expdate);
		timetrack.selectTask(ConstantsVariable.taskname3, ConstantsVariable.hr);
		String res1=timetrack.submitbtn();
		Assert.assertTrue(res1.contains("successfully"),"fail to create task");	
		
	}
	
	@Test(description="create new task")
	public void test4()
	{
		LoginPage loginpage = new LoginPage(driver);	
		String res=loginpage.validLogin(ConstantsVariable.username, ConstantsVariable.password, ConstantsVariable.title);
		Assert.assertEquals(driver.getTitle(), res,"fail to login");
		HomePage homepage = new HomePage(driver);
		homepage.timeTrackTab();
		TimeTrack timetrack = new TimeTrack(driver);
		timetrack.selectItemFromDropdown(ConstantsVariable.taskusername1);
		timetrack.calender(ConstantsVariable.expMonth, ConstantsVariable.expdate);
		timetrack.selectTask(ConstantsVariable.taskname1, ConstantsVariable.hr);
		String res1=timetrack.submitbtn();
		Assert.assertTrue(res1.contains("successfully"),"fail to create task");	
		
	}
}
