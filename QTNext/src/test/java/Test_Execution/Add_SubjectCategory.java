package Test_Execution;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Pages.Admin_Set_SubCat;

public class Add_SubjectCategory extends Admin_Set_SubCat
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
		Click(d,Settings);
		delay(d, SubjectCategory, 1);
		Click(d, SubjectCategory);
	}
	@Test(priority=2)
	public void addCourse() throws IOException, InterruptedException
	{
		add_SubjectCategory(d);
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
