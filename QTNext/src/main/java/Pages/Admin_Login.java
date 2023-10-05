package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Generic_Methods;

public class Admin_Login extends Generic_Methods 
{
	public By Username =By.xpath("//input[@placeholder='Enter username']");
	public By Password =By.xpath("//input[@placeholder='Enter password']");
	public By Signin=By.xpath("//button[@type='submit']");
	
	public void login(WebDriver driver, String uname, String pass)
	{
		SendKeys(driver, Username, uname);
		SendKeys(driver, Password, pass);
		Click(driver, Signin);
		
	}

}
