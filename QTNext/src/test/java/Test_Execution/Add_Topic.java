package Test_Execution;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.Admin_CreateTopic;

public class Add_Topic extends Admin_CreateTopic
{
	WebDriver d;
	@BeforeClass
	public void l() throws Exception 
	{
		d = lunchUrl();
		login(d, "qtnext", "qtnext@123");
	}
	@Test(priority=1)
	public void createChapter()
	{
		Click(d, Learning_Path);
		delay(d, Create_Topic, 1);
		Click(d, Create_Topic);
	}
	@Test(priority=2)
	public void addTopic() throws IOException, InterruptedException
	{
		add_Topic(d);
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