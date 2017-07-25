package locatorRepository;

import org.openqa.selenium.By;

public class WebElementRepository 
{
	// login page locators 
	public By headerfield=By.id("headerContainer");
	public By errormsg=By.xpath(".//*[@id='ErrorsTable']/tbody/tr/td[2]/table/tbody/tr/td/span");
	public By loginbttn = By.partialLinkText("Login");
	public	By usernamefield = By.id("username");
	public By passwordfield = By.name("pwd");			
	public	By checkboxfield=By.id("keepLoggedInCheckBox");
	public By loggoutlink= By.id("logoutLink");
	
	// home page locators
	public By timetrackmenu=By.xpath(".//*[@id='topnav']/tbody/tr[1]/td[2]/a");
	public By usermenu=By.xpath(".//*[@id='topnav']/tbody/tr[1]/td[5]/a");
	public By taskmenu=By.xpath(".//*[@id='topnav']/tbody/tr[1]/td[3]/a");
	public By reportmenu = By.xpath(".//*[@id='topnav']/tbody/tr[1]/td[4]/a");
	public By dropdownlink=By.xpath(".//*[@id='enterTTMainContent']/table[1]/tbody/tr[1]/td[1]/div/table/tbody/tr/td[3]/table/tbody/tr/td[2]/div/span");
	public By dropdownitems=By.cssSelector(".userName");
	
	// time track loctors
	public By calenderLink = By.id("ext-gen23");
	public By monthlabel=By.cssSelector(".x-date-middle");
	public By forwardbtn=By.xpath("//a[@title='Next Month (Control+Right)']");
	public By previousbtn=By.xpath("//a[@title='Previous Month (Control+Left)']");
	public By calenderTable=By.xpath("//li/div[1]/table[starts-with(@id,'ext-gen')]");
	public By addrecentTask = By.xpath(".//*[@id='recentTasksControl']/tbody/tr/td/div[1]/span[1]");
	public By recenttaskitems=By.cssSelector(".taskName>span>span");
	
	public By savebtn=By.id("SubmitTTButton");
	public By msg = By.xpath(".//*[@id='SuccessMessages']/tbody/tr/td/span");
	
}
