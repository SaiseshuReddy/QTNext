package Test_Execution;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.Admin_CreateAssessmentQuestions;

public class Add_AssessmentQuestion extends Admin_CreateAssessmentQuestions
{
	WebDriver d;
	@BeforeClass
	public void l() throws Exception 
	{
		d = lunchUrl();
		login(d, "qtnext", "qtnext@123");
	}
	@Test(priority=1)
	public void createAssessmentQuestions()
	{
		Click(d,Assessment_Path);
		delay(d, Create_AssessmentQuestions, 1);
		Click(d,Create_AssessmentQuestions);
	}
	@Test(priority=2)
	public void addAssessment() throws IOException, InterruptedException
	{
		add_AssessmentQuestions(d);
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
