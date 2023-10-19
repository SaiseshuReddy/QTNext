package Test_Execution;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Pages.Admin_Set_Subject;
public class Add_Subject extends Admin_Set_Subject
{
	WebDriver d;
	@BeforeClass
	public void l() throws Exception 
	{
		d = lunchUrl();
		login(d, "qtnext", "qtnext@123");
	}
	@Test(priority=1)
	public void Subject()
	{
		Click(d,Settings);
		delay(d, Subject, 1);
		Click(d, Subject);
	}
	@Test(priority=2)
	public void addSubject() throws IOException, InterruptedException
	{
		add_Subject(d);
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
