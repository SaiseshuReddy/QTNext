package Test_Execution;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Pages.Admin_CreateCourse;

public class Add_Course extends Admin_CreateCourse 
{
	WebDriver d;
	@BeforeClass
	public void l() throws Exception 
	{
		d = lunchUrl();
		login(d, "qtnext", "qtnext@123");
	}
	@Test(priority=1)
	public void createCourse()
	{
		Click(d,Learning_Path);
		delay(d, Create_Course, 1);
		Click(d,Create_Course);
	}
	@Test(priority=2)
	public void addCourse() throws IOException, InterruptedException
	{
		add_Course(d);
	}
	@AfterClass
	public void quit()
	{
		d.quit();
	}
	@AfterMethod
	public void BugScreen(ITestResult result) throws Exception
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Screen_Shot(d, result.getName());
		}
	}
}