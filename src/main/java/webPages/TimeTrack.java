package webPages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TimeTrack extends HomePage
{
	public TimeTrack(WebDriver driver) 
	{
		super(driver);		
	}

	public void selectItemFromDropdown(String expUser)
	{
		lib.explicitWait1(repo.dropdownlink);
		int count=0;
		while(count<4)
		{
			try
			{
				lib.clickonElement(repo.dropdownlink);
				List<WebElement> list1 =driver.findElements(repo.dropdownitems);
				for (WebElement var : list1) 
				{
					System.out.println(var.getText());
					if(var.getText().equals(expUser))	
					{
						var.click(); break;
					}
				}count=count+4; break;
			}
			catch (Exception e) 
			{
				System.out.println("exception occured in Task method " + e);
				count=count+1; continue;
			}
		}
		lib.explicitWait(repo.dropdownlink, expUser);
	}

	public void calender(String month, String date) 
	{		
		int count=0;
		while(count<4)
		{
			try
			{
				Thread.sleep(5000);
				int i=0;
				lib.clickonElement(repo.calenderLink);
				for(i=0; i<3;i++)
				{
					String monthlble=lib.getElementText(repo.monthlabel);
					System.out.println(monthlble);
					if(!monthlble.contains(month))
					{
						lib.clickonElement(repo.forwardbtn);
					}
					else {break;}
					count=count+4;
				}
				if(i>=3)
				{
					for(int j=0; j<6;j++)
					{
						String monthlble=lib.getElementText(repo.monthlabel);
						if(!monthlble.contains(month))
						{
							lib.clickonElement(repo.previousbtn);					
						}
						else {break;}
						count=count+4;
					}
				}
			}
			catch (Exception e) 
			{
				System.out.println("exception occured in Task method " + e);
				count=count+1; continue;
			}
		}
		selectdate(date);
	}

	private void selectdate(String date)
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int count=0;
		while(count<4)
		{
			try
			{
				WebElement tble=driver.findElement(repo.calenderTable);
				List<WebElement>row=tble.findElements(By.tagName("tr"));
				for(int i=0; i<row.size();i++)
				{
					List<WebElement>column=row.get(i).findElements(By.tagName("td"));
					for(int j=0; j<column.size();j++)
					{
						String actdate=column.get(j).getText();
						if(actdate.equals(date))
						{
							column.get(j).click(); count=count+4; 
							break;							
						}
					}
				}
			}
			catch (Exception e) 
			{
				System.out.println("exception occured in Task method " + e);
				count=count+1; continue;
			}
		}
	}

	public void selectTask(String taskname, String hrs)
	{
		int count=0;
		while(count<4)
		{
			try
			{
				Thread.sleep(2000);
				lib.clickonElement(repo.addrecentTask);
				Thread.sleep(5000);
				List<WebElement> list1 = driver.findElements(repo.recenttaskitems);
				for(WebElement var : list1) 
				{
					if(var.getText().equals(taskname))
					{
						var.click(); count =count+4;
						break;
					}
				}lib.sendkeysESC();
				count=count+4;
				typeHrdata(taskname,hrs);
			}
			catch (Exception e) 
			{
				System.out.println("exception occured in Task method " + e);
				count=count+1; continue;
			}
		}
	}


	private void typeHrdata(String taskname, String hrs)
	{
		By hrfield=By.xpath("//span[text()='"+taskname+"']/following::input[@class='text inputTT']");
		int count=0;
		while(count<4)
		{
			try
			{
				List<WebElement> list2 = driver.findElements(hrfield);

				for(int i=0; i<5; i++)
				{
					list2.get(i).clear();
					list2.get(i).sendKeys(hrs);
				}
				count=count+4;
			}
			catch (Exception e) 
			{
				System.out.println("exception occured in Task method " + e);
				count=count+1; continue;
			}
		}
	}

	public String submitbtn()
	{
		lib.clickonElement(repo.savebtn);
		lib.explicitWait1(repo.msg);
		return lib.getElementText(repo.msg);
	}
}
