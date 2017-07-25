package commonLib;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods 
{
	public WebDriver driver;
	public WebDriverWait wait;
	
	public ReusableMethods(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickonElement(By locatorpath)
	{
		driver.findElement(locatorpath).click();
	}
	
	public void typeData(By locatorpath,String data)
	{
		driver.findElement(locatorpath).sendKeys(data);
	}
	
	public String getElementText(By locatorpath)
	{
		return driver.findElement(locatorpath).getText();
	}

	public String getElementAttributehref(By locatorpath)
	{
		return driver.findElement(locatorpath).getAttribute("href");
	}
	
	public String getElementAttributePlaceholder(By locatorpath)
	{
		return driver.findElement(locatorpath).getAttribute("placeholder");
	}

	public boolean checkElementDisplayed(By locatorpath)
	{
		return driver.findElement(locatorpath).isDisplayed();
	}

	public boolean checkElementEnabled(By locatorpath)
	{
		return driver.findElement(locatorpath).isEnabled();
	}
	
	public boolean checkElementselected(By locatorpath)
	{
		return driver.findElement(locatorpath).isSelected();
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public String getPageUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public void explicitWait1(By locatorpath)
	{
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(locatorpath));
	}
	
	public void explicitWait(String title)
	{
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public void explicitWait(By locatorpath,String text)
	{
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBe(locatorpath, text));
	}
	
	public void sendkeysESC()
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ESCAPE).perform();
	}
	
	
}
