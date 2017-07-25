package webPages;

import org.openqa.selenium.WebDriver;

import commonLib.ReusableMethods;
import locatorRepository.WebElementRepository;

public class HomePage
{
	public WebDriver driver;
	ReusableMethods lib;
	WebElementRepository repo;
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		lib= new ReusableMethods(driver);
		repo = new WebElementRepository();
	}

	public void timeTrackTab()
	{
		lib.explicitWait1(repo.timetrackmenu);
		if(!lib.getPageTitle().contains("Enter"))
		{
			lib.clickonElement(repo.timetrackmenu);
		}
	}

	public void taskTab()
	{
		lib.explicitWait1(repo.taskmenu);
		if(!lib.getPageTitle().contains("Open"))
		{
			lib.clickonElement(repo.taskmenu);
		}
	}
	
	public void reportTab()
	{
		if(!lib.getPageTitle().contains("Reports"))
		{
			lib.clickonElement(repo.reportmenu);
		}
	}
	
	public void userTab()
	{
		if(!lib.getPageTitle().contains("User"))
		{
			lib.clickonElement(repo.usermenu);
		}
	}
	
	public void logout()
	{
		if(!lib.getPageTitle().contains("Login"))
		{
			lib.clickonElement(repo.loggoutlink);
		}
	}


}
