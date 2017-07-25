package webPages;

import org.openqa.selenium.WebDriver;

import commonLib.ReusableMethods;
import locatorRepository.WebElementRepository;

public class LoginPage 
{
	public WebDriver driver;
	ReusableMethods lib;
	WebElementRepository repo;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		lib= new ReusableMethods(driver);
		repo = new WebElementRepository();
	}

	private void setUsername(String data)
	{
		lib.typeData(repo.usernamefield, data);
	}

	private void setPassword(String data)
	{
		lib.typeData(repo.passwordfield, data);
	}

	private void checkBox()
	{
		if(!lib.checkElementselected(repo.checkboxfield))
		{
			lib.clickonElement(repo.checkboxfield);
		}
	}

	private void loginbtn()
	{
		lib.clickonElement(repo.loginbttn);
	}

	public String validLogin(String username, String password, String title)
	{
		if(lib.checkElementDisplayed(repo.headerfield))
		{
			System.out.println("page loaded");
			setUsername(username);
			setPassword(password);
			checkBox();
			loginbtn();
			lib.explicitWait(title);			
		}
		else {
			System.out.println("page not loaded");
		}
		return lib.getPageTitle();
	}

	public String inValidLogin(String usernamewrong, String passwordwrong)
	{
		lib.explicitWait1(repo.headerfield);
		try {
			if(lib.checkElementDisplayed(repo.headerfield))
			{
				System.out.println("page loaded");
				setUsername(usernamewrong);
				setPassword(passwordwrong);
				checkBox();
				loginbtn();
				lib.explicitWait1(repo.errormsg);	
			}
			else {
				System.out.println("page not loaded");
			}
			Thread.sleep(2000);
		}
		catch (Exception e) {
			// TODO: handle exception
		}		
		return lib.getElementText(repo.errormsg);
	}

	public String verifyPlaceholderUsername()
	{
		return lib.getElementAttributePlaceholder(repo.usernamefield);
	}

	public String verifyPlaceholderPassword()
	{
		return lib.getElementAttributePlaceholder(repo.passwordfield);
	}
}